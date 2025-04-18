package weather.app;

public class Comparing {
    public static String comapare(WeatherData data) {
        if (data.getRainProbability() > 70 ||
                data.getWindSpeed() > 50 ||
                data.getWaveHeight() > 2.5 ||
                data.isStorms() ||
                data.getVisibility() < 3 ||
                data.isLightning()) {
            return "❌ Not Safe to Go";
        } else if (data.getRainProbability() > 50 ||
                data.getWindSpeed() > 30 ||
                data.getWaveHeight() > 1.5) {
            return "⚠️ Caution: Risky Conditions";
        } else {
            return "✅ Safe to Go";
        }
    }
}
