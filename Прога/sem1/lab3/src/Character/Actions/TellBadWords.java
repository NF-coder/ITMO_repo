package src.Character.Actions;

import src.Character.BasicCharacter;
import src.Character.CharacterMethods.CharacterName;

public class TellBadWords {
    private final CharacterName name;
    public TellBadWords(CharacterName name) {
        this.name = name;
    }

    public void tellBadWords(){
        System.out.print(
                name.getName() +
                        " на все лады проклинал коротышек, вздумавших, словно ему назло, взрыхлить вокруг землю и насадить на его пути все эти кустики. "
        );
    }
}
