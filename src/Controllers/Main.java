package Controllers;

import Controllers.Views.TitleScene_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage=primaryStage;
        this.initRootLayout();
        this.showTitleScene();
    }

    private void initRootLayout(){

        try{

            //Load Fxml File
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Views/RootLayout.fxml"));
            this.rootLayout= (BorderPane) loader.load();

            //Create RootLayout Scene
            Scene rootLayoutScene=new Scene(this.rootLayout);

            //Set Scene to Stage
            this.primaryStage.setScene(rootLayoutScene);
            this.primaryStage.show();

        }catch (IOException e){

            e.printStackTrace();
        }
    }

    public void showTitleScene(){

        try{

            //Load Fxml File
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(Main.class.getResource("Views/TitleScene_UI.fxml"));
            AnchorPane titleScene=(AnchorPane) loader.load();

            //Set Title Scene Controller
            TitleScene_Controller controller=loader.getController();
            controller.setMainApp(this);

            //Set  Title Scene to RootLayout
            this.rootLayout.setCenter(titleScene);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
