package Controllers.Views;

import Controllers.Main;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class GameScene_Controller {

    private Main mainApp;

    @FXML
    private Canvas canvas;

    public void setMainApp(Main mainApp){
        this.mainApp=mainApp;
    }
    
}
