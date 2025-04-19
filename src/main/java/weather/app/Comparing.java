package weather.app;

public class Comparing {

    public static String compare(WeatherData data) {
        System.out.println("Debug data");
        System.out.println("Rain Probability: " + data.getRainProbability());
        System.out.println("Wind Speed: " + data.getWindSpeed());
        System.out.println("Visibility: " + data.getVisibility());
        System.out.println("Lightning: " + data.isLightning());
        System.out.println("Storms: " + data.isStorms());
        System.out.println("Debug data end");

        if (data.getRainProbability() > 70 || data.getWindSpeed() > 50 || data.isStorms()
                || data.getVisibility() < 1000
                || data.isLightning()) {
            return " Not Safe to Go";
        } else if (data.getRainProbability() > 50 ||
                data.getWindSpeed() > 30) {
            return " Caution: Risky Conditions";
        } else {
            return " Safe to Go";
        }
    }
}
