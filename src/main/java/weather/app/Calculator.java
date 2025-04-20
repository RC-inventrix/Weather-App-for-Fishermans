package weather.app;

public class Calculator {

    public static void waterConsumption(Inputs inputData) {
        double water = inputData.getNoOfCrewMembers() * 25 * inputData.getMaxDays();
        System.out.println("Maximum water Consumption: " + water + " liters");
    }

    public static void foodConsumption(Inputs inputData) {
        double food = inputData.getNoOfCrewMembers() * 2.5 * inputData.getMaxDays();
        System.out.println("Maximum food Consumption: " + food + " kg");
    }

    public static void fuelConsumption(Inputs inputData) {
        double fuel = 500 * inputData.getMaxDays();
        System.out.println("Maximum fuel Consumption: " + fuel + " liters");
    }
}
