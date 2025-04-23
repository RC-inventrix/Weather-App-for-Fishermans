package weather.app;

public class IntegrationTest {
    public static void main(String[] args) {
        Inputs inputData = new Inputs();
        inputData.setLocation("Matara");
        inputData.setDateTime("2025-04-23 09:00:00");
        inputData.setNoOfCrewMembers(5);
        inputData.setMaxDays(2);

        FinalDecision.finalDecision(inputData);
    }
}
