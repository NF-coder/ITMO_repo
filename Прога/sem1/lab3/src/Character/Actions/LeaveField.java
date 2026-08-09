package src.Character.Actions;

import src.Character.CharacterMethods.CharacterName;

public class LeaveField {
    CharacterName characterName;
    public LeaveField(CharacterName characterName) {
        this.characterName = characterName;
    }
    public void leaveField(){
        System.out.print("Как и следовало ожидать, ему все же удалось в конце концов добраться до края картофельного поля. " +
                "Выбравшись на твердую почву," +
                characterName.getName() +
                "облегченно вздохнул "
        );
    }
}
