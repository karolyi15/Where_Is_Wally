package Factory;

import javafx.scene.canvas.GraphicsContext;
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
        this.scaleImageHeight(sceneHeight);
    }

    @Override
    public void onUpdate(GraphicsContext drawer){

        drawer.drawImage(image, this.readerPosition[0],this.readerPosition[1],this.readerDimensions[0],this.readerDimensions[1],this.position[0],this.position[1],this.width,this.height);
    }
}
