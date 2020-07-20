package Controllers.Models;

import Controllers.Views.GameScene_Controller;
import Factory.Background;
import Factory.Character;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class GameScene {

    private AnimationTimer gameLoop;
    private Background background;
    private ArrayList<Character> characters;
    private ArrayList<Character> waldosCharacters;
    private GameScene_Controller controller;

    public GameScene(){

    }


    public void setBackground(Background background) {
        this.background = background;
        this.background.config(700,500);
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;

    }

    public void setWaldosCharacters(ArrayList<Character> waldosCharacters) {
        this.waldosCharacters = waldosCharacters;
    }

    public void setController(GameScene_Controller controller) {
        this.controller = controller;
    }

    private void onUpdate(){

        //Update Scene Background
        this.background.onUpdate(this.controller.getDrawer());

        //Update Game Characters
        for(int character=0;character<this.characters.size();character++){

            this.characters.get(character).onUpdate(this.controller.getDrawer());
        }

        //Update Special Characters
        for(int specialCharacter=0;specialCharacter<this.waldosCharacters.size();specialCharacter++){

            this.waldosCharacters.get(specialCharacter).onUpdate(this.controller.getDrawer());
        }
    }

    private void handleMouseEvents(){
        this.controller.getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){

                  for(int character=0;character<waldosCharacters.size();character++){

                      Character tempCharacter=waldosCharacters.get(character);

                      if(tempCharacter.getPositionX()<=mouseEvent.getX() & mouseEvent.getX()<= tempCharacter.getPositionX()+ tempCharacter.getWidth()) {
                          if (tempCharacter.getPositionY() < mouseEvent.getY() & mouseEvent.getY() < tempCharacter.getPositionY() + tempCharacter.getHeight()){

                              System.out.println("Click on Character");
                              waldosCharacters.remove(character);
                              isGameOver();

                          }
                      }
                  }
                }
            }
        });

    }

    private void isGameOver(){

        if(this.waldosCharacters.size()==0){
            this.gameLoop.stop();
            controller.showConfirmationDialog();
        }
    }

    public void start(){

        this.handleMouseEvents();

        this.gameLoop= new AnimationTimer() {
            @Override
            public void handle(long l) {
                onUpdate();
            }
        };
        this.gameLoop.start();
    }


}
