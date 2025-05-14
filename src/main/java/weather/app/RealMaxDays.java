package weather.app;

public class RealMaxDays {
    final static int FORECASTQTY = 8;

    public static int realMaxDays(Inputs inputdata) {
        int numberOfForecasts = inputdata.getMaxDays() * FORECASTQTY;
        WeatherData data = null;
        Inputs inputdataCopy = inputdata;
        for (int i = 0; i < numberOfForecasts; i++) {
            data = DataRetriever.dataRetriever(inputdataCopy);




            int result = Comparing.compare(data);


            if (result == -1) {

                return (i / FORECASTQTY);
            }

            inputdataCopy.setDateTime(ThreeHourTimeUpdater.updateTime(inputdataCopy));
        }

        return inputdata.getMaxDays(); // All forecasts safe
    }
}
