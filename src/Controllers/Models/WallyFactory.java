package Controllers.Models;

import Factory.Character;
import Factory.CharacterFactory;
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
    Random random;

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

            specialCharacters.add(tempCharacter);
        }

        return specialCharacters;
    }

    public Character createSpecialCharacter(){

        int specialCharacter= this.random.nextInt(this.openSetSpecial.size());

        Character tempCharacter= new Character((JSONObject) this.openSetSpecial.get(specialCharacter));
        tempCharacter.setId(String.valueOf(specialCharacter));

        tempCharacter.setPosition(100,100);

        this.openSetSpecial.remove(specialCharacter);

        return tempCharacter;

    }


}
