package weather.app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control. *;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private TextArea iDcrews;
    @FXML
    private TextArea iDmaxdays;
    @FXML
    private Button iDenter;
    @FXML
    private Button iDreset;
    @FXML
    private TextArea iDresults;
    @FXML
    private ChoiceBox<String> iDlocation;
    @FXML
    private DatePicker iDdate;
    @FXML
    private ChoiceBox<String> iDtime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        iDlocation.getItems().addAll("Galle", "Matara", "Hambantota", "Trincomalee", "Jaffna",
                "Negombo", "Colombo", "Batticaloa", "Kalpitiya");

        iDtime.getItems().addAll("00:00:00","03:00:00","06:00:00","09:00:00","12:00:00","15:00:00","18:00:00","21:00:00");






    }

    private void handleEnterButton() {
        Inputs inputData = new Inputs();
        inputData.setLocation(iDlocation.getValue());
        DateTimeIntergration.datetimeintegration(iDdate.getValue().toString(), iDtime.getValue(), inputData);
        inputData.setNoOfCrewMembers(Integer.parseInt(iDcrews.getText().trim()));
        inputData.setMaxDays(Integer.parseInt(iDmaxdays.getText().trim()));



    }
    private void handleResetButton() {
        iDcrews.clear();
        iDmaxdays.clear();
        iDresults.clear();
        iDlocation.setValue(null);
        iDdate.setValue(null);
        iDtime.setValue(null);
    }


}