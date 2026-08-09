package src.Locations;

import src.Locations.LocationsEnums.GroundType;
import src.Character.BasicCharacter;

public class FieldStart extends Location {

    public FieldStart(BasicCharacter character) {
        super("FieldStart", character);
    }

    public void execute(){
        final BasicCharacter character = this.getCharacter();
        final int potatoesCnt = rnd.randomizePotatoes();
        final GroundType groundType = rnd.randomizeGroundType();

        character.claimPotatoes.claimPotatoes(potatoesCnt, rnd.randomizeGroundType());

        if (rnd.nextFloat(0,1) < 0.7f){

            if (!character.bitePotato.bite()){
                if (rnd.nextFloat(0,1) < 0.7f){
                    character.throwPotatoes.throwPotatoes();
                } else {
                    character.savePotatoes.saveUnusefulPotatoes(groundType, potatoesCnt);
                    character.checkIfClothBroken.checkIfClothBroken();
                }
            } else {
                character.savePotatoes.saveUsefulPotatoes(groundType, potatoesCnt);
                character.checkIfClothBroken.checkIfClothBroken();
            }
        } else {
            character.savePotatoes.savePotatoesFastly();
            character.checkIfClothBroken.checkIfClothBroken();
        }

        character.characterLocation.setLocation(new FieldMiddle(character, groundType));
    }
}
