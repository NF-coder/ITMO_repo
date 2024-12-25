package src.Locations;

import src.Locations.LocationsEnums.GroundType;
import src.Character.BasicCharacter;

public class FieldStart extends Location {

    public FieldStart(BasicCharacter character) {
        super("FieldStart", character);
    }

    public Location execute(){
        final BasicCharacter character = this.getCharacter();
        final int potatoesCnt = rnd.randomizePotatoes();
        final GroundType groundType = rnd.randomizeGroundType();

        character.claimPotatoes(potatoesCnt, rnd.randomizeGroundType());

        if (rnd.nextFloat(0,1) < 0.7f){

            if (!character.bite()){
                if (rnd.nextFloat(0,1) < 0.7f){
                    character.throwPotatoes();
                } else {
                    character.saveUnusefulPotatoes(groundType, potatoesCnt);
                    character.checkIfClothBroken();
                }
            } else {
                character.saveUsefulPotatoes(groundType, potatoesCnt);
                character.checkIfClothBroken();
            }
        } else {
            character.savePotatoesFastly();
            character.checkIfClothBroken();
        }

        return new FieldMiddle(character, groundType);
    }
}
