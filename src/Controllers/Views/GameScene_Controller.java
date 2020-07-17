package Controllers.Views;

import Controllers.Main;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameScene_Controller {

    private Main mainApp;
    private GraphicsContext drawer;

    @FXML
    private Canvas canvas;

    public void setMainApp(Main mainApp){
        this.mainApp=mainApp;
    }

    @FXML
    private void initialize(){
        this.drawer=this.canvas.getGraphicsContext2D();
    }


}
