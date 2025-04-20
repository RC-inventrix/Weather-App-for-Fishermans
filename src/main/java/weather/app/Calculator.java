package weather.app;

public class Calculator {

    public static void Consumption(Inputs inputData, int days) {
        System.out.println("Approximating the consumptions...");
        double water = inputData.getNoOfCrewMembers() * 25 * days;
        System.out.println("Maximum water Consumption: " + water + " liters");

        double food = inputData.getNoOfCrewMembers() * 2.5 * days;
        System.out.println("Maximum food Consumption: " + food + " kg");

        double fuel = 500 * days;
        System.out.println("Maximum fuel Consumption: " + fuel + " liters");

    }
}
