package src.Locations;

import src.Character.BasicCharacter;
import src.Clothes.Cloth;
import src.Clothes.ClothesEnum;
import src.Locations.FieldStartPkg.GroundType;

public class FieldStart extends Location {

    public FieldStart(BasicCharacter character) {
        super("FieldStart", character);
    }

    private void pickCloth(BasicCharacter character){
        int pickCloth = rnd.nextInt(ClothesEnum.values().length);
        character.setCloth(
                ClothesEnum.values()[pickCloth].toCloth(rnd.nextInt(1,3))
        );
    }


    public Location run(){
        final BasicCharacter character = this.getCharacter();
        final String characterName = character.getName();
        final int potatoesCnt = this.rnd.nextInt(1, 20);

        character.setPotatoes(potatoesCnt);

        int pickGround = rnd.nextInt(GroundType.values().length);

        System.out.println(characterName +
                " достаёт " +
                potatoesCnt +
                " клубней из " +
                GroundType.values()[pickGround]
        );

        if (rnd.nextFloat(0,1) < 0.7f){
            System.out.println("Скуперфильд откусил кусочек и попробовал его разжевать.");

            if (rnd.nextFloat(0,1) < 0.5f){
                if (rnd.nextFloat(0,1) < 0.7f){
                    character.throwPotatoes();
                } else {
                    pickCloth(character);
                    System.out.println("Сообразив, однако, что никто не стал бы выращивать совершенно бесполезных плодов, он сунул вытащенные из " +
                            GroundType.values()[pickGround] +
                            " " +
                            potatoesCnt +
                            " картофелин в карман "+
                            character.getCloth().name()
                    );
                }
            } else {
                pickCloth(character);
                System.out.println("Сырой картофель оказался весьма сносным, поэтому он сунул вытащенные из " +
                        GroundType.values()[pickGround] +
                        " " +
                        potatoesCnt +
                        " картофелин в карман "+
                        character.getCloth().name()
                );
            }
        } else {
            pickCloth(character);
            System.out.println("Затем он быстро суёт их в карман " + character.getCloth().name());
        }

        return new FieldMiddle(character);
    }
}
