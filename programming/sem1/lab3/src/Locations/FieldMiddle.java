package src.Locations;

import src.Character.BasicCharacter;

public class FieldMiddle extends Location{

    public FieldMiddle(BasicCharacter character) {
        super("FieldMiddle", character);
    }

    public Location run(){
        System.out.println("Шагать по рыхлой земле, беспрерывно путаясь ногами в картофельной ботве, было очень утомительно.");

        BasicCharacter character = this.getCharacter();

        final int fieldLenght = rnd.nextInt(1,5);
        int reclaimPotatoes = 0;

        character.setEnergy(
                rnd.nextInt(0, fieldLenght+(character.getPotatoes()/2))
        );

        if (character.getCloth().stepIncriment()*fieldLenght > character.getPotatoes()){
            System.out.println("В какой-то момент " +
                    character.getName() +
                    "Скуперфильд ощутил необычайную лёгкость и решил проверить карманы. Он обнаружил, что из прорех вывалился весь картофель,"
            );


            try {
                reclaimPotatoes = rnd.nextInt(0,character.getPotatoes()/2);
                if (reclaimPotatoes != 0){
                    System.out.println("он вернулся назад на несколько шагов и подобрал последние " + reclaimPotatoes + " картофелиин.");
                } else {
                    System.out.println("он решил не подбирать картофель и пойти дальше.");
                }
            } catch (IllegalArgumentException e){ // bound must be greater than origin
                System.out.println("он решил не подбирать картофель и пойти дальше.");
            }
        }

        return new FieldEnd(character, fieldLenght + reclaimPotatoes);
    }
}
