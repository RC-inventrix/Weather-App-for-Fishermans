package weather.app;

import java.sql.*;
import java.net.*;
import java.io.*;
import org.json.*;

public class WeatherDataUpdater {

    static final String DB_URL = "jdbc:mysql://localhost:3306/weather_app";
    static final String DB_USER = "root"; // default for XAMPP
    static final String DB_PASS = ""; // default is empty

    static final String API_KEY = "85b0108dcedddfd215efcd3d8561ed8e";
    static String[] locations = { "Galle", "Matara", "Hambantota", "Trincomalee", "Jaffna", "Negombo", "Colombo",
            "Batticaloa", "Kalpitiya" };

    public static void main(String[] args) {
        try {
            for (String city : locations) {

                String urlStr = "https://api.openweathermap.org/data/2.5/forecast?q=" + city +
                        ",LK&appid=" + API_KEY + "&units=metric";

                URL url = URI.create(urlStr).toURL();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                conn.disconnect();

                JSONObject json = new JSONObject(content.toString());
                JSONArray list = json.getJSONArray("list");

                // Connect to DB
                Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

                String query = "INSERT INTO weather_data (location, forecast_time, wind_speed, rain_probability, visibility, weather_condition) "
                        +
                        "VALUES (?, ?, ?, ?, ?, ?) " +
                        "ON DUPLICATE KEY UPDATE wind_speed = VALUES(wind_speed), rain_probability = VALUES(rain_probability), visibility = VALUES(visibility), weather_condition = VALUES(weather_condition)";

                PreparedStatement stmt = con.prepareStatement(query);

                for (int i = 0; i < list.length(); i++) {
                    JSONObject obj = list.getJSONObject(i);

                    String forecastTime = obj.getString("dt_txt");
                    double wind = obj.getJSONObject("wind").getDouble("speed");
                    int visibility = json.has("visibility") ? json.getInt("visibility") : 10000;
                    double rainProb = obj.has("pop") ? obj.getDouble("pop") * 100 : 0;

                    JSONArray weatherArray = obj.getJSONArray("weather");
                    String condition = weatherArray.getJSONObject(0).getString("main");

                    stmt.setString(1, city);
                    stmt.setString(2, forecastTime);
                    stmt.setDouble(3, wind);
                    stmt.setDouble(4, rainProb);
                    stmt.setInt(5, visibility);
                    stmt.setString(6, condition);

                    stmt.executeUpdate();
                }

                con.close();
                System.out.println("✅ Weather data updated successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
