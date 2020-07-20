package Factory;

import javafx.scene.canvas.GraphicsContext;
import org.json.simple.JSONObject;

public class Character extends Sprite {

    //********************************************************************************************************//
    //********************************************* CLASS FIELDS *********************************************//

    private String id;
    private CharacterType type;

    //********************************************************************************************************//
    //******************************************** CLASS METHODS *********************************************//

    //*** Constructor ***
    public Character(JSONObject characterData){

        super(characterData.get("ImgPath").toString().replaceAll("\\\\",""));
        this.parseType((String) characterData.get("Type"));
    }

    public Character(String imgPath){
        super(imgPath);
    }

    private void parseType(String type){

        switch (type){
            case "GROUND":
                this.type=CharacterType.GROUND;
            case "FLYING":
                this.type=CharacterType.FLYING;
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //*** Render System ***
    @Override
    public void onUpdate(GraphicsContext drawer){
        drawer.drawImage(image, this.readerPosition[0],this.readerPosition[1],this.readerDimensions[0],this.readerDimensions[1],this.position[0],this.position[1],this.width,this.height);

    }

}
