package Controllers.Views;

import Controllers.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AboutScene_Controller {

    private Stage aboutStage;

    @FXML
    private Label title;
    @FXML
    private TextArea content;
    @FXML
    private Button ok_Button;

    public void setAboutStage(Stage aboutStage){
        this.aboutStage = aboutStage;
    }

    @FXML
    public void onHandleOk(){
        this.aboutStage.close();
    }

}
