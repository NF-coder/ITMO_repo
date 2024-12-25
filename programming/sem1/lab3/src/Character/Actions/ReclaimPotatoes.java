package src.Character.Actions;

import src.Character.CharacterMethods.CharacterCloth;
import src.Character.CharacterMethods.CharacterEnergy;
import src.Locations.FieldMethods.FieldLenght;
import src.Random.RandomWrapper;

public class ReclaimPotatoes {
    private final RandomWrapper rnd;
    private final FieldLenght fieldLenght;
    private final CharacterEnergy characterEnergy;
    private final CharacterCloth characterCloth;
    public ReclaimPotatoes(RandomWrapper rnd, FieldLenght fieldLenght, CharacterEnergy characterEnergy, CharacterCloth characterCloth, GoFurther goFurther) {
        this.rnd = rnd;
        this.fieldLenght = fieldLenght;
        this.characterEnergy = characterEnergy;
        this.characterCloth = characterCloth;
        this.goFurther = goFurther; // &
    }

    public void reclaimPotatoes() {
        int reclaimPotatoes = rnd.ramdomizePotatoesReclamation(
                this.characterEnergy.getEnergy(),
                characterCloth.getCloth().getPotatoesCount()
        );
        this.characterEnergy.setEnergy(
                this.characterEnergy.getEnergy() - reclaimPotatoes
        );
        this.fieldLenght.setFieldLenght(
                this.fieldLenght.getFieldLenght() + reclaimPotatoes
        );

        if (reclaimPotatoes != 0) {
            System.out.print("он вернулся назад на несколько шагов и подобрал последние " + reclaimPotatoes + " картофелиин. ");
        }
        else { character.goFurther(); }
    }
}
