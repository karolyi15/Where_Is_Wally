package Factory;

import org.json.simple.JSONObject;

public class Character extends Sprite {

    //********************************************************************************************************//
    //********************************************* CLASS FIELDS *********************************************//

    private CharacterType type;

    //********************************************************************************************************//
    //******************************************** CLASS METHODS *********************************************//

    //*** Constructor ***
    public Character(JSONObject characterData){

        super(characterData.get("ImgPath").toString().replaceAll("\\\\",""));
        this.parseType((String) characterData.get("Type"));
    }

    private void parseType(String type){

        switch (type){
            case "GROUND":
                this.type=CharacterType.GROUND;
            case "FLYING":
                this.type=CharacterType.FLYING;
        }
    }
    //*** Render System ***
    @Override
    public void onUpdate(){
        System.out.print("Character Updated");
    }

}
