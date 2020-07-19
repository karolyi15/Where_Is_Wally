package Factory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class BackgroundFactory extends Factory {

    //********************************************************************************************************//
    //********************************************* CLASS FIELDS *********************************************//

    private JSONArray openSet;

    //********************************************************************************************************//
    //******************************************** CLASS METHODS *********************************************//

    //*** Constructor ***
    public BackgroundFactory(){

        this.loadDataBase();
    }

    @Override
    protected void loadDataBase(){

        JSONParser parser = new JSONParser();

        try(Reader reader = new FileReader(this.dataBasePath)){

            this.dataBase = (JSONObject) parser.parse(reader);
            this.openSet = (JSONArray) this.dataBase.get("Backgrounds");

        }catch (IOException e){

            e.printStackTrace();
            this.showErrorDialog("Error while accessing to data base");

        }catch (ParseException e){

            e.printStackTrace();
            this.showErrorDialog("Error while loading data base");
        }
    }

    public void addBackground(String imgPath, double groundX, double groundY,double groundW, double groundH, double flyingX, double flyingY, double flyingW, double flyingH){

        JSONObject tempBackground = new JSONObject();

        JSONObject backgroundGround = new JSONObject();
        backgroundGround.put("PositionX",groundX);
        backgroundGround.put("PositionY",groundY);
        backgroundGround.put("Width",groundW);
        backgroundGround.put("Height",groundH);

        JSONObject backgroundFlying = new JSONObject();
        backgroundFlying.put("PositionX",flyingX);
        backgroundFlying.put("PositionY",flyingY);
        backgroundFlying.put("Width",flyingW);
        backgroundFlying.put("Height",flyingH);

        tempBackground.put("ImgPath", "file: "+imgPath);
        tempBackground.put("Ground", backgroundGround);
        tempBackground.put("Flying",backgroundFlying);

        this.openSet.add(tempBackground);
        this.dataBase.put("Backgrounds",this.openSet);

        this.updateDataBase();
    }

    @Override
    public Sprite createProduct(){

        Random random = new Random();
        int randomBackground = random.nextInt(this.openSet.size());

        return new Background((JSONObject) this.openSet.get(randomBackground));
    }



}
