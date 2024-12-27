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

    public void execute(){
        BasicCharacter character = this.getCharacter();
        character.tellBadWords.tellBadWords();

        StepStatus lastStepStatus = StepStatus.OK;
        while (this.fieldLenght.getFieldLenght() != 0){
            lastStepStatus = character.makeSteps.makeStepAfterReclaim();
            if (lastStepStatus == StepStatus.OK){
                this.fieldLenght.incrementFieldLenght();
            }
            else{ break; }
        }

        if (lastStepStatus == StepStatus.LAST_STEP) {
            character.sleepOnGround.sleepOnGround();
        } else {
            character.leaveField.leaveField();
            if (rnd.randomizeCanSmell()){ character.smellFood.smellFood(); }
            else { character.enjoyGrass.enjoyGrass(); }
        }

        character.characterLocation.setLocation(null);
    }
}
