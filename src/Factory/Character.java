package Factory;

public class Character extends Sprite {

    public Character(String imgPath){
        super(imgPath);
    }

    @Override
    public void onUpdate(){
        System.out.print("Character Update");
    }

}
