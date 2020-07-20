package Controllers.Models;

public class SceneDirector {

    private SceneBuilder builder;

    public GameScene buildGame(){

        this.builder.restart();
        this.builder.buildBackground();
        this.builder.buildCharacters();
        this.builder.buildWaldosCharacters();

        return builder.getResult();
    }

    public void setBuilder(SceneBuilder builder){
        this.builder=builder;
    }

}
