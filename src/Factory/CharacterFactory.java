package Factory;

public class CharacterFactory extends Factory{




    @Override
    public Sprite createProduct(){
        return new Character("");
    }
}
