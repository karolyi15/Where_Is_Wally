package Controllers.Views;

import Controllers.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TitleScene_Controller {

    private Main mainApp;

    @FXML
    private Button start_Button;
    @FXML
    private Button about_Button;
    @FXML
    private ImageView logo;
    @FXML
    private AnchorPane scene;

    @FXML
    private void initialize(){
        scene.setStyle("-fx-background-color: #000000");
        this.logo.setImage(new Image("file:Resources/Imgs/UI/Title.jpg"));
    }
    public void setMainApp(Main mainApp){
        this.mainApp=mainApp;
    }

    @FXML
    private void onHandleStart(){

       this.mainApp.showGameScene();
    }

    @FXML
    private void onHandleAbout(){

       this.mainApp.showAboutScene();
    }
}
