package src.Locations;

import src.Character.StepsEnums.StepStatusAfterReclaim;
import src.Character.BasicCharacter;

public class FieldEnd extends Location{
    private int fieldLenght;

    private void setFieldLenght(int fieldLenght) {
        this.fieldLenght = fieldLenght;
    }
    private int getFieldLenght() {return this.fieldLenght;}
    private void incrementFieldLenght(){
        this.setFieldLenght(this.getFieldLenght()-1);
    }

    public FieldEnd(BasicCharacter character, int fieldLenght) {
        super("FieldEnd", character);
        this.fieldLenght = fieldLenght;
    }

    public Location run(){
        BasicCharacter character = this.getCharacter();
        character.tellBadWords();

        StepStatusAfterReclaim lastStepStatus = StepStatusAfterReclaim.OK;
        while (this.getFieldLenght() != 0){
            lastStepStatus = character.makeStepAfterReclaim();
            if (lastStepStatus == StepStatusAfterReclaim.OK){
                this.incrementFieldLenght();
            }
            else{break;}
        }

        if (lastStepStatus == StepStatusAfterReclaim.LAST_STEP) {
            System.out.print("Он еле-еле смог доползти до конца поля и ступив на твёрдую землю он сразу лёг в траву и уснул.");
        } else {
            System.out.print("Как и следовало ожидать, ему все же удалось в конце концов добраться до края картофельного поля. " +
                    "Выбравшись на твердую почву, Скуперфильд облегченно вздохнул "
            );

            if (rnd.randomizeCanSmell()){
                System.out.print("и в тот же момент ощутил доносившийся откуда-то запах " +
                        rnd.randomizeSmell() +
                        ". От этого запаха на него словно повеяло теплом и домашним уютом.");
            } else {
                System.out.print(". Он ещё никогда не был так рад ощущать траву под ногами.");
            }
        }

        return null;
    }
}
