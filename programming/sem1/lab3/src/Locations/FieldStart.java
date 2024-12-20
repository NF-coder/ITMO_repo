package src.Locations;

import src.Character.BasicCharacter;
import src.Character.Skuperfild;

public class FieldStart extends Location {

    public FieldStart(BasicCharacter character) {
        super("FieldStart", character);
    }
    public Location run(){
        final BasicCharacter character = this.getCharacter();
        final String characterName = character.getName();
        final int potatoesCnt = this.rnd.nextInt(1, 20);

        character.setPotatoes(potatoesCnt);
        System.out.println(characterName + " достаёт " + potatoesCnt + " клубней из ");


        return null;
        //(от 1 до 20 [POTATO INT]) и отряхивает его от случайного типа грунта (к пимеру песок/земля (Enum)).");
    }
}
