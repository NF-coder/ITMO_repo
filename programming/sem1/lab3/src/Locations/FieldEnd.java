package src.Locations;

import src.Character.BasicCharacter;
import src.Character.Actions.StepsEnums.StepStatus;
import src.Locations.FieldMethods.FieldLenght;

public class FieldEnd extends Location{
    final private FieldLenght fieldLenght = new FieldLenght();

    public FieldEnd(BasicCharacter character, int fieldLenght) {
        super("FieldEnd", character);
        this.fieldLenght.setFieldLenght(fieldLenght);
    }

    public Location execute(){
        BasicCharacter character = this.getCharacter();
        character.tellBadWords();

        StepStatus lastStepStatus = StepStatus.OK;
        while (this.fieldLenght.getFieldLenght() != 0){
            lastStepStatus = character.makeStepAfterReclaim();
            if (lastStepStatus == StepStatus.OK){
                this.fieldLenght.incrementFieldLenght();
            }
            else{break;}
        }

        if (lastStepStatus == StepStatus.LAST_STEP) {
            character.sleepOnGround();
        } else {
            character.leaveField();
            if (rnd.randomizeCanSmell()){ character.smellFood(); }
            else { character.enjoyGrass(); }
        }

        return null;
    }
}
