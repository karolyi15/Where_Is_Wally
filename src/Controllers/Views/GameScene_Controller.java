package Controllers.Views;

import Controllers.Main;
import Controllers.Models.GameScene;
import Controllers.Models.SceneBuilder;
import Controllers.Models.SceneDirector;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class GameScene_Controller {

    //********************************************************************************************************//
    //********************************************* CLASS FIELDS *********************************************//

    private Main mainApp;
    private GraphicsContext drawer;
    private SceneBuilder builder;
    private SceneDirector director;

    private GameScene game;

    @FXML
    private Canvas canvas;

    //********************************************************************************************************//
    //******************************************** CLASS METHODS *********************************************//

    public void setMainApp(Main mainApp){
        this.mainApp=mainApp;
    }

    @FXML
    private void initialize(){

        this.drawer=this.canvas.getGraphicsContext2D();

        this.builder=new SceneBuilder();
        this.director= new SceneDirector();

        this.director.setBuilder(this.builder);
        this.game=this.director.buildGame();

        this.game.setController(this);
        this.game.start();
    }

    public GraphicsContext getDrawer() {
        return drawer;
    }

    public void setDrawer(GraphicsContext drawer) {
        this.drawer = drawer;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void showConfirmationDialog(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Play Again?");
        alert.setContentText("Click ok to play again\n Click cancel to return to the menu");

        Optional<ButtonType> result=alert.showAndWait();

        if(result.get() == ButtonType.OK){

            System.out.println("New Game");

        }else{

            this.mainApp.showTitleScene();

        }
    }
}
