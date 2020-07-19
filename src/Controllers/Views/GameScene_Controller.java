package Controllers.Views;

import Controllers.Main;
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
    }


    private void showConfirmationDialog(){

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
