package src;

import src.Character.BasicCharacter;
import src.Clothes.Cloth;
import src.Locations.FieldStart;
import src.Random.RandomWrapper;

public class Main {
    public static void main(String[] args) {
        BasicCharacter Character1 = new BasicCharacter("Скуперфильд");
        final Cloth cloth = new RandomWrapper().randomizeCloth();
        Character1.characterCloth.setCloth(cloth);

        FieldStart Location1 = new FieldStart(Character1);
        Character1.characterLocation.setLocation(Location1);

        while (Character1.characterLocation.getLocation() != null) {
            Character1.characterLocation.getLocation().execute();
        }
        
        System.out.println();
    }
}
