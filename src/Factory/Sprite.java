package Factory;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public abstract class Sprite {

    //********************************************************************************************************//
    //********************************************* CLASS FIELDS *********************************************//

    //Render System
    private String imgPath;

    private Image image;
    private double width;
    private double height;

    //Resize System
    private double[] readerPosition;
    private double[] readerDimensions;

    //Positioning System
    private double[] position;

    //********************************************************************************************************//
    //******************************************** CLASS METHODS *********************************************//

    //Constructor
    public Sprite(String imgPath){

        //Render System
        this.imgPath=imgPath;
        this.image=new Image(this.imgPath);
        this.width=this.image.getWidth();
        this.height=this.image.getHeight();

        //Physics System
        this.position=new double[2];

        //Resized System
        this.readerPosition=new double[2];
        this.readerDimensions=new double[2];
        this.readerDimensions[0]=this.width;
        this.readerDimensions[1]=this.height;

    }

    //*** Positioning System ***
    public void setPosition(double positionX, double positionY){
        this.position[0]=positionX;
        this.position[1]=positionY;
    }

    public void setPositionX(double positionX){
        this.position[0]=positionX;
    }

    public void setPositionY(double positionY){
        this.position[1]=positionY;
    }

    public double[] getPosition(){
        return this.position;
    }

    public double getPositionX(){
        return this.position[0];
    }

    public double getPositionY(){
        return this.position[1];
    }

    //*** Movement System ***
    public void translateX(double translate){
        this.position[0]+=translate;
    }

    public void translateY(double translate){
        this.position[1]+=translate;
    }

    //*** Render System ***
    public void setImage(String imgPath){
        this.imgPath=imgPath;
        this.image=new Image(this.imgPath);
        //this.image=new Image(this.imgPath,this.width,this.height,false,false);
        //this.readerDimensions[0]=this.image.getWidth();
        //this.readerDimensions[1]=this.image.getHeight();

    }

    public Image getImage(){
        return this.image;
    }

    public void resizeImage(double width,double height){
        this.width=width;
        this.height=height;
    }

    public void getImgSection(int positionX, int positionY, int width, int height){
        this.readerPosition[0]=positionX;
        this.readerPosition[1]=positionY;

        this.readerDimensions[0]=width;
        this.readerDimensions[1]=height;
    }

    public String getImgPath(){
        return this.imgPath;
    }

    public double getWidth(){
        return this.width;

    }
    public double getHeight(){
        return this.height;
    }

    public abstract void onUpdate();

    //Collide System
    public Rectangle2D getBoundary(){
        return new Rectangle2D(this.position[0],this.position[1],this.width,this.height);
    }
    public boolean collide(Sprite tempSprite){
        return tempSprite.getBoundary().intersects(this.getBoundary());
    }

}
