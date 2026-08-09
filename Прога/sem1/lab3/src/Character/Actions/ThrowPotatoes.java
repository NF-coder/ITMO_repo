package src.Character.Actions;

import src.Character.BasicCharacter;
import src.Character.Actions.Exceptons.NegativePotatoesException;
import src.Character.CharacterMethods.CharacterCloth;
import src.Character.CharacterMethods.CharacterName;

public class ThrowPotatoes {
    private final CharacterCloth cloth;
    private final CharacterName name;
    public ThrowPotatoes(CharacterCloth cloth, CharacterName name) {
        this.cloth = cloth;
        this.name = name;
    }

    public void throwPotatoes(){
        try {
            cloth.getCloth().setPotatoes(0);
            System.out.print(name.getName() + " швырнул картофель в сторону. ");
        }
        catch (NegativePotatoesException e){
            System.out.println("Error: check your code, idiot!");
        }
    }
}
