package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


    public static void main(String[] args) {
        launch(args);
    }
}
