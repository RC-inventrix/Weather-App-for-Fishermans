package weather.app;

public class RealMaxDays {
    final static int FORECASTQTY = 8;

    public static int realMaxDays(Inputs inputdata) {
        int numberOfForecasts = inputdata.getMaxDays() * FORECASTQTY;
        WeatherData data = null;
        for (int i = 0; i < numberOfForecasts; i++) {
            data = DataRetriever.dataRetriever(inputdata);
            if (Comparing.compare(data) == -1) {
                return i / FORECASTQTY;
            }
            inputdata.setDateTime(ThreeHourTimeUpdater.updateTime(inputdata));
        }

        return inputdata.getMaxDays();
    }
}
