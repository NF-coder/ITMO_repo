package src.Character.Actions;

import src.Character.CharacterMethods.CharacterCloth;
import src.Character.CharacterMethods.CharacterEnergy;
import src.Locations.FieldMethods.FieldLenght;
import src.Random.RandomWrapper;

public class ReclaimPotatoes {
    private final RandomWrapper rnd;
    private final CharacterEnergy characterEnergy;
    private final CharacterCloth characterCloth;
    private final GoFurther goFurther;

    public ReclaimPotatoes(RandomWrapper rnd, CharacterEnergy characterEnergy, CharacterCloth characterCloth, GoFurther goFurther) {
        this.rnd = rnd;
        this.characterEnergy = characterEnergy;
        this.characterCloth = characterCloth;
        this.goFurther = goFurther;
    }

    public void reclaimPotatoes(FieldLenght fieldLenght) throws IllegalArgumentException{
        int reclaimPotatoes = rnd.ramdomizePotatoesReclamation(
                this.characterEnergy.getEnergy(),
                characterCloth.getCloth().getPotatoesCount()
        );
        this.characterEnergy.setEnergy(
                this.characterEnergy.getEnergy() - reclaimPotatoes
        );
        fieldLenght.setFieldLenght(
                fieldLenght.getFieldLenght() + reclaimPotatoes
        );

        if (reclaimPotatoes != 0) {
            System.out.print("он вернулся назад на несколько шагов и подобрал последние " + reclaimPotatoes + " картофелиин. ");
        }
        else { goFurther.goFurther(); }
    }
}
