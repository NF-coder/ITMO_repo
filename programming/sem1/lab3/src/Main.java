package src;

import src.Character.BasicCharacter;
import src.Clothes.Cloth;
import src.Locations.FieldEnd;
import src.Locations.FieldMiddle;
import src.Locations.FieldStart;
import src.Random.RandomWrapper;

public class Main {
    public static void main(String[] args) {
        BasicCharacter Character1 = new BasicCharacter("Скуперфильд");
        final Cloth cloth = new RandomWrapper().randomizeCloth();
        Character1.characterCloth.setCloth(cloth);

        FieldStart Location1 = new FieldStart(Character1);
        FieldMiddle Location2 = (FieldMiddle) Location1.execute();
        FieldEnd Location3 = (FieldEnd) Location2.execute();
        try { Location3.execute(); }
        catch (NullPointerException e){ }
        
        System.out.println();
    }
}
