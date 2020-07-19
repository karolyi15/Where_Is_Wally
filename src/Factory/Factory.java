package Factory;

import javafx.scene.control.Alert;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public abstract class Factory {

    //********************************************************************************************************//
    //********************************************* CLASS FIELDS *********************************************//

    protected String dataBasePath;
    protected JSONObject dataBase;

    //********************************************************************************************************//
    //******************************************** CLASS METHODS *********************************************//

    //*** Constructor ***
    public Factory(){

        this.dataBasePath="Resources/DataBase.json";
    }

    public void changeDataBase(String jsonFilePath){
        this.dataBasePath=jsonFilePath;
    }

    protected abstract void loadDataBase();

    protected void updateDataBase(){

        try(FileWriter writer = new FileWriter(this.dataBasePath)){

            writer.write(dataBase.toJSONString());

        }catch (IOException e){

            e.printStackTrace();
        }
    }

    public abstract Sprite createProduct();

    protected void showErrorDialog(String content){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("There was an error!!");
        alert.setContentText(content);

        alert.showAndWait();
    }
}
