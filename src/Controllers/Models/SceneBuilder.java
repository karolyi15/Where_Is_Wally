package Controllers.Models;

import Controllers.Views.GameScene_Controller;
import Factory.Background;
import Factory.BackgroundFactory;
import Factory.Character;

import java.util.ArrayList;

public class SceneBuilder {

    private GameScene scene;
    private WallyFactory characterFactory;
    private BackgroundFactory backgroundFactory;

    public SceneBuilder(){

        this.scene = new GameScene();
        this.characterFactory = new WallyFactory();
        this.backgroundFactory = new BackgroundFactory();
    }

    public void restart(){

        this.scene = new GameScene();
    }

    public void buildBackground(){

        this.scene.setBackground((Background) backgroundFactory.createProduct());
    }

    public void buildCharacters(){

        ArrayList<Character> characters = new ArrayList<>();

        for(int character=0;character<60;character++){

            characters.add((Character) characterFactory.createProduct());
        }

        this.scene.setCharacters(characters);
    }

    public void buildWaldosCharacters(){

        this.scene.setWaldosCharacters(this.characterFactory.createSpecialCharacters());
    }

    public GameScene getResult(){

        return this.scene;
    }


}
