package src.Locations;

import src.Character.BasicCharacter;
import src.Character.StepsEnums.StepStatus;

public class FieldMiddle extends Location{
    int fieldLenght;

    public FieldMiddle(BasicCharacter character) {
        super("FieldMiddle", character);
        this.setFieldLenght(rnd.randomizeFieldLenght());
    }

    private void setFieldLenght(int fieldLenght) {
        this.fieldLenght = fieldLenght;
    }
    private int getFieldLenght() {return this.fieldLenght;}
    private void incrementFieldLenght(){
        this.setFieldLenght(this.getFieldLenght()-1);
    }

    public Location run(){
        BasicCharacter character = this.getCharacter();
        int reclaimPotatoes = 0;
        character.setEnergy(
                rnd.randomizeEnergy(fieldLenght,character.getCloth().getPotatoesCount())
        );

        System.out.print("Шагать по рыхлой земле, беспрерывно путаясь ногами в картофельной ботве, было очень утомительно. ");

        StepStatus lastStepStatus = StepStatus.OK;
        while (this.getFieldLenght() != 0){
            lastStepStatus = character.makeStep();
            if (lastStepStatus == StepStatus.OK){
                this.incrementFieldLenght();
            }
            else{  break; }
        }
        if (lastStepStatus == StepStatus.NOT_ENOUGH_POTATOES) {
            try {
                reclaimPotatoes = rnd.ramdomizePotatoesReclamation(
                        character.getEnergy(),
                        character.getCloth().getPotatoesCount()
                );
                character.setEnergy(
                        character.getEnergy()-reclaimPotatoes
                );
                this.setFieldLenght(
                        this.getFieldLenght() + reclaimPotatoes
                );

                if (reclaimPotatoes != 0) {
                    System.out.print("он вернулся назад на несколько шагов и подобрал последние " + reclaimPotatoes + " картофелиин. ");
                } else {
                    System.out.print("он решил не подбирать картофель и пойти дальше. ");
                }
            } catch (IllegalArgumentException e2) { // bound must be greater than origin
                System.out.print("он решил не подбирать картофель и пойти дальше. ");
            }
        }
        else if (lastStepStatus == StepStatus.NOT_ENOUGH_ENERGY) {
            System.out.print("В какой-то момент он окончательно выбился из сил, сел посреди поля и стал ожидать чего-то, сам не зная чего. ");
            return null;
        }



        return new FieldEnd(character, fieldLenght);
    }
}
