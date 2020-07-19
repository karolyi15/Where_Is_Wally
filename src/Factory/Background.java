package Factory;

import org.json.simple.JSONObject;

public class Background extends Sprite {

    //********************************************************************************************************//
    //********************************************* CLASS FIELDS *********************************************//

    private JSONObject ground;
    private JSONObject flying;

    //********************************************************************************************************//
    //******************************************** CLASS METHODS *********************************************//

    //*** Constructor ***
    public Background(JSONObject backgroundData){

        super(backgroundData.get("ImgPath").toString().replaceAll("\\\\",""));

        this.ground = (JSONObject) backgroundData.get("Ground");
        this.flying = (JSONObject) backgroundData.get("Flying");
    }

    public void config(double sceneWidth, double sceneHeight){

        //Resize and center image in stage
    }

    @Override
    public void onUpdate(){

        System.out.println("Background updated");
    }
}
