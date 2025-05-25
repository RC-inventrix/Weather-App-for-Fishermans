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
        Inputs inputData = new Inputs();
        iDlocation.getItems().addAll("Galle", "Matara", "Hambantota", "Trincomalee", "Jaffna",
                "Negombo", "Colombo", "Batticaloa", "Kalpitiya");


        iDtime.getItems().addAll("00:00:00","03:00:00","06:00:00","09:00:00","12:00:00","15:00:00","18:00:00","21:00:00");






    }


}