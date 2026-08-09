package src.Locations;

import src.Character.BasicCharacter;
import src.Character.Actions.StepsEnums.StepStatus;
import src.Locations.FieldMethods.FieldLenght;
import src.Locations.LocationsEnums.GroundType;

public class FieldMiddle extends Location{
    final private FieldLenght fieldLenght = new FieldLenght();
    private final GroundType groundType;

    public FieldMiddle(BasicCharacter character, GroundType groundType) {
        super("FieldMiddle", character);
        this.fieldLenght.setFieldLenght(rnd.randomizeFieldLenght());
        this.groundType = groundType;
    }

    public void execute(){
        BasicCharacter character = this.getCharacter();
        character.characterEnergy.setEnergy(
                rnd.randomizeEnergy(this.fieldLenght.getFieldLenght(),
                        character.characterCloth.getCloth().getPotatoesCount()
                )
        );

        character.getTiredOfWalk.getTiredOfWalk(this.groundType);

        StepStatus lastStepStatus = StepStatus.OK;
        while (this.fieldLenght.getFieldLenght() != 0){
            lastStepStatus = character.makeStep();
            if (lastStepStatus == StepStatus.OK){
                this.fieldLenght.incrementFieldLenght();
            }
            else{  break; }
        }
        if (lastStepStatus == StepStatus.NOT_ENOUGH_POTATOES) {
            try {
                character.reclaimPotatoes.reclaimPotatoes(this.fieldLenght);
            } catch (IllegalArgumentException e2) { character.goFurther.goFurther(); }
        }
        else if (lastStepStatus == StepStatus.NOT_ENOUGH_ENERGY) {
            character.becomeTired.becomeTired();

            character.characterLocation.setLocation(null);
        }

        character.characterLocation.setLocation(new FieldEnd(character, this.fieldLenght.getFieldLenght()));
    }
}
