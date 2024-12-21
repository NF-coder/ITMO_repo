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
        final int stepIncriment;
        if (rnd.nextFloat(0,1) < 0.7f){
            stepIncriment = rnd.nextInt(1,3);
        } else {
            stepIncriment = 0;
        }
        character.setCloth(
                ClothesEnum.values()[pickCloth].toCloth(stepIncriment)
        );
    }

    private void printIfBroken(Cloth cloth){
        if (cloth.stepIncriment() != 0) {
            System.out.print("Однако он оказался дырявым и при каждом шаге вываливалось " + cloth.stepIncriment() + " клубней. ");
        }
    }


    public Location run(){
        final BasicCharacter character = this.getCharacter();
        final String characterName = character.getName();
        final int potatoesCnt = this.rnd.nextInt(1, 20);

        character.setPotatoes(potatoesCnt);

        int pickGround = rnd.nextInt(GroundType.values().length);

        System.out.print(characterName +
                " достаёт " +
                potatoesCnt +
                " клубней из " +
                GroundType.values()[pickGround] +
                ". "
        );

        if (rnd.nextFloat(0,1) < 0.7f){
            System.out.print("Скуперфильд откусил кусочек и попробовал его разжевать. ");

            if (rnd.nextFloat(0,1) < 0.5f){
                System.out.print("Сырой картофель показался ему страшно невкусным, даже противным. ");
                if (rnd.nextFloat(0,1) < 0.7f){
                    character.throwPotatoes();
                } else {
                    pickCloth(character);
                    System.out.print("Сообразив, однако, что никто не стал бы выращивать совершенно бесполезных плодов, он сунул вытащенные из " +
                            GroundType.values()[pickGround] +
                            " " +
                            potatoesCnt +
                            " картофелин в карман "+
                            character.getCloth().name() +
                            ". "
                    );
                    printIfBroken(character.getCloth());
                }
            } else {
                pickCloth(character);
                System.out.print("Сырой картофель оказался весьма сносным, поэтому он сунул вытащенные из " +
                        GroundType.values()[pickGround] +
                        " " +
                        potatoesCnt +
                        " картофелин в карман " +
                        character.getCloth().name() +
                        ". "
                );
                printIfBroken(character.getCloth());
            }
        } else {
            pickCloth(character);
            System.out.print("Затем он быстро суёт их в карман " + character.getCloth().name() + ". ");
            printIfBroken(character.getCloth());
        }

        return new FieldMiddle(character);
    }
}
