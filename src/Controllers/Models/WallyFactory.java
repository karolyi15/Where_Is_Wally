package Controllers.Models;

import Factory.Character;
import Factory.CharacterFactory;
import Factory.Sprite;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

public class WallyFactory extends CharacterFactory {

    protected JSONArray openSetSpecial;
    private Random random;

    public WallyFactory(){

        this.random= new Random();
    }

    @Override
    protected void loadDataBase(){

        JSONParser parser = new JSONParser();

        try(Reader reader = new FileReader(this.dataBasePath)){

            this.dataBase = (JSONObject) parser.parse(reader);
            this.openSet = (JSONArray) this.dataBase.get("Characters");
            this.openSetSpecial= (JSONArray) this.dataBase.get("WallyCharacters");

        }catch (IOException e){

            e.printStackTrace();
            this.showErrorDialog("Error while accessing to data base");

        }catch (ParseException e){

            e.printStackTrace();
            this.showErrorDialog("Error while loading data base");
        }
    }


    public ArrayList<Character> createSpecialCharacters(){

        ArrayList<Character> specialCharacters= new ArrayList<>();

        for(int character=0;character<this.openSetSpecial.size();character++){

            Character tempCharacter= new Character((JSONObject) this.openSetSpecial.get(character));
            tempCharacter.setId(String.valueOf(character));
            tempCharacter.scaleImageHeight(100);
            tempCharacter.setPosition(random.nextInt(700),random.nextInt(500));

            specialCharacters.add(tempCharacter);
        }

        return specialCharacters;
    }

    public Character createSpecialCharacter(){

        int specialCharacter= this.random.nextInt(this.openSetSpecial.size());

        Character tempCharacter= new Character((JSONObject) this.openSetSpecial.get(specialCharacter));
        tempCharacter.setId(String.valueOf(specialCharacter));
        tempCharacter.scaleImageHeight(100);
        tempCharacter.setPosition(random.nextInt(700),random.nextInt(500));

        this.openSetSpecial.remove(specialCharacter);

        return tempCharacter;

    }

    @Override
    public Sprite createProduct(){

        Random random = new Random();
        int randomCharacter = random.nextInt(this.openSet.size());

        Character tempCharacter=new Character((JSONObject) this.openSet.get(randomCharacter));
        tempCharacter.scaleImageHeight(100);
        tempCharacter.setPosition(random.nextInt(700),random.nextInt(500));

        return tempCharacter;
    }


}
