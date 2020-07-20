package Factory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class CharacterFactory extends Factory{

    //********************************************************************************************************//
    //********************************************* CLASS FIELDS *********************************************//

    protected JSONArray openSet;

    //********************************************************************************************************//
    //******************************************** CLASS METHODS *********************************************//

    //*** Constructor ***
    public CharacterFactory(){

      this.loadDataBase();
    }

    @Override
    protected void loadDataBase(){

        JSONParser parser = new JSONParser();

        try(Reader reader = new FileReader(this.dataBasePath)){

            this.dataBase = (JSONObject) parser.parse(reader);
            this.openSet = (JSONArray) this.dataBase.get("Characters");

        }catch (IOException e){

            e.printStackTrace();
            this.showErrorDialog("Error while accessing to data base");

        }catch (ParseException e){

            e.printStackTrace();
            this.showErrorDialog("Error while loading data base");
        }
    }


    public void addCharacter(String imgPath, CharacterType type){

        JSONObject tempCharacter = new JSONObject();
        tempCharacter.put("ImgPath", "file: "+imgPath);
        tempCharacter.put("Type", type.toString());

        this.openSet.add(tempCharacter);
        this.dataBase.put("Characters",this.openSet);

        this.updateDataBase();
    }


    @Override
    public Sprite createProduct(){

        Random random = new Random();
        int randomCharacter = random.nextInt(this.openSet.size());

        return new Character((JSONObject) this.openSet.get(randomCharacter));
    }
}
