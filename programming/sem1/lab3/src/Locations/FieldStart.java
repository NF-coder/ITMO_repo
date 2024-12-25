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
                    System.out.print("Сообразив, однако, что никто не стал бы выращивать совершенно бесполезных плодов, он сунул вытащенные из " +
                            groundType +
                            " " +
                            potatoesCnt +
                            " картофелин в карман "+
                            character.characterName.getName() +
                            ". "
                    );
                    character.checkIfClothBroken();
                }
            } else {
                System.out.print(", поэтому он сунул вытащенные из " +
                        groundType +
                        " " +
                        potatoesCnt +
                        " картофелин в карман " +
                        character.characterCloth.getCloth().getName() +
                        ". "
                );
                character.checkIfClothBroken();
            }
        } else {
            System.out.print("Затем он быстро суёт их в карман " + character.characterCloth.getCloth().getName() + ". ");
            character.checkIfClothBroken();
        }

        return new FieldMiddle(character, groundType);
    }
}
