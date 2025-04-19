package weather.app;

import java.sql.*;

public class IntegrationTest {
    public static void main(String[] args) {
        Inputs testInputs = new Inputs();

        testInputs.setLocation("Matara");

        testInputs.setDateTime("2025-04-20 15:00:00");

        String DB_URL = "jdbc:mysql://localhost:3306/weather_app";
        String DB_USER = "root";
        String DB_PASS = "";
        WeatherData testdata = new WeatherData();
        System.out.println(" Starting Integration Test...");

        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String sql = "SELECT * FROM weather_data WHERE location = ? AND forecast_time = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            String location = testInputs.getLocation();
            String forecastTime = testInputs.getDateTime(); // "2025-04-20 15:00:00"

            System.out.println(" Querying for Location: " + location + ", Forecast Time: " + forecastTime);
            stmt.setString(1, location);

            stmt.setTimestamp(2, Timestamp.valueOf(forecastTime));

            ResultSet rs = stmt.executeQuery();

            String weatherCondition = null;
            if (rs.next()) {
                System.out.println(" Data found! Loading into testdata...");

                testdata.setRainProbability(rs.getDouble("rain_probability"));
                testdata.setWindSpeed(rs.getDouble("wind_speed"));
                testdata.setVisibility(rs.getInt("visibility"));
                weatherCondition = rs.getString("weather_condition");
                testdata.setLightning(weatherCondition.contains("thunder"));
                testdata.setStorms(weatherCondition.contains("storm"));

            } else {
                System.out.println(" No data found for given location and time.");

                System.out.println("No data found for the given location and time. ");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        System.out.println("What is the situation? " + Comparing.compare(testdata));

    }
}
