package src.Locations;

import src.Character.BasicCharacter;

public class FieldMiddle extends Location{

    public FieldMiddle(BasicCharacter character) {
        super("FieldMiddle", character);
    }

    public Location run(){
        System.out.print("Шагать по рыхлой земле, беспрерывно путаясь ногами в картофельной ботве, было очень утомительно. ");

        BasicCharacter character = this.getCharacter();

        final int fieldLenght = rnd.nextInt(1,5);
        final int halvedPotatoes = character.getPotatoes()/2;
        int reclaimPotatoes = 0;

        character.setEnergy(
                rnd.nextInt(0, fieldLenght+halvedPotatoes)
        );

        if (character.getCloth().stepIncriment()*fieldLenght > character.getPotatoes()){
            System.out.print("В какой-то момент " +
                    character.getName() +
                    " ощутил необычайную лёгкость и решил проверить карманы. Он обнаружил, что из прорех вывалился весь картофель, "
            );


            try {
                reclaimPotatoes = rnd.nextInt(0,halvedPotatoes);
                if (reclaimPotatoes != 0){
                    System.out.print("он вернулся назад на несколько шагов и подобрал последние " + reclaimPotatoes + " картофелиин. ");
                } else {
                    System.out.print("он решил не подбирать картофель и пойти дальше. ");
                }
            } catch (IllegalArgumentException e){ // bound must be greater than origin
                System.out.print("он решил не подбирать картофель и пойти дальше. ");
            }
        }

        return new FieldEnd(character, fieldLenght + reclaimPotatoes);
    }
}
