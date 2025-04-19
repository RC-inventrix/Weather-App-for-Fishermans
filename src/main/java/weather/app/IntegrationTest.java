package weather.app;

import java.sql.*;
/*import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;*/

public class IntegrationTest {
    public static void main(String[] args) {
        Inputs testInputs = new Inputs();
        // testInputs.setDate(java.time.LocalDate.of(2025, 4, 20));
        testInputs.setLocation("Matara");
        // testInputs.setTime(java.time.LocalTime.of(15, 00, 00));
        testInputs.setDateTime("2025-04-20 21:00:00");

        String DB_URL = "jdbc:mysql://localhost:3306/weather_app";
        String DB_USER = "root";
        String DB_PASS = "";
        WeatherData testdata = new WeatherData();

        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            String sql = "SELECT * FROM weather_data WHERE location = ? AND forecast_time = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            String location = testInputs.getLocation();
            String forecastTime = testInputs.getDateTime(); // "2025-04-20 15:00:00"
            // LocalDate date = testInputs.getDate();
            // LocalTime time = testInputs.getTime();

            // LocalDateTime start = LocalDateTime.of(date, time.minusHours(1));
            // LocalDateTime end = LocalDateTime.of(date, time.plusHours(1));

            stmt.setString(1, location);
            // stmt.setTimestamp(2, Timestamp.valueOf(start));
            // stmt.setTimestamp(3, Timestamp.valueOf(end));
            stmt.setTimestamp(2, Timestamp.valueOf(forecastTime));

            ResultSet rs = stmt.executeQuery();

            String weatherCondition = null;
            if (rs.next()) {
                testdata.setRainProbability(rs.getDouble("rain_probability"));
                testdata.setWindSpeed(rs.getDouble("wind_speed"));
                testdata.setVisibility(rs.getInt("visibility"));
                weatherCondition = rs.getString("weather_condition");
                testdata.setLightning(weatherCondition.contains("thunder"));
                testdata.setStorms(weatherCondition.contains("storm"));

            } else {
                System.out.println("No data found for the given location and time. ");
            }

        } catch (SQLException e) {

            e.printStackTrace();

            System.out.println("What is the situation? " + Comparing.compare(testdata));
        }

    }
}
