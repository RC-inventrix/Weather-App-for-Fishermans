package weather.app;

public class FinalDecision {
    public static void finalDecision(Inputs inputdata) {
        WeatherData data = DataRetriever.dataRetriever(inputdata);
        System.out.println();
        if (Comparing.compare(data) == -1) {
            System.out.println("The trip is not recommended due to bad weather conditions.");
        } else {
            System.out.println("The trip is recommended based on the weather conditions.");
            int result =RealMaxDays.realMaxDays(inputdata);
            if (result == 0) {
                System.out.println(
                        "Unfortunately based on the weather condition of the rest of the day, you cannot stay for the whole day.");
            } else if (result< inputdata.getMaxDays()) {
                System.out
                        .println("You can only stay safely for only " + result + " days.");
                Calculator.Consumption(inputdata, result);
            } else {
                System.out.println("You can stay your maximumly expected  " + inputdata.getMaxDays() + " days.");
                Calculator.Consumption(inputdata, inputdata.getMaxDays());
            }

        }
    }
}
