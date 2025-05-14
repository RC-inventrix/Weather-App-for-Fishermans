package weather.app;

public class IntegrationTest {
    public static void main(String[] args) {
        Inputs inputData = new Inputs();
        inputData.setLocation("Trincomalee");
        inputData.setDateTime("2025-05-14 21:00:00");
        inputData.setNoOfCrewMembers(5);
        inputData.setMaxDays(3);

        FinalDecision.finalDecision(inputData);
    }
}
