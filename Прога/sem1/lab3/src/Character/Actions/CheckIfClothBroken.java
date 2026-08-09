package src.Character.Actions;

import src.Character.BasicCharacter;
import src.Character.CharacterMethods.CharacterCloth;

public class CheckIfClothBroken {
    private final CharacterCloth cloth;
    public CheckIfClothBroken(CharacterCloth cloth) {
        this.cloth = cloth;
    }
    // check if cloth broken
    public void checkIfClothBroken(){
        if (this.cloth.getCloth().getStepIncrement() != 0) {
            System.out.print("Однако он оказался дырявым и при каждом шаге вываливалось " + this.cloth.getCloth().getStepIncrement() + " клубней. ");
        }
    }
}
