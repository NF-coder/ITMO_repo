package src;

import src.Character.Skuperfild;
import src.Clothes.Cloth;
import src.Locations.FieldStart;
import src.Locations.Location;

public class Main {
    public static void main(String[] args) {
        Skuperfild Character1 = new Skuperfild();
        Cloth Cloth1 = new Cloth("Cloth1", 1);

        Character1.setCloth(Cloth1);

        FieldStart Location1 = new FieldStart(Character1);
        Location1.run();
    }
}
