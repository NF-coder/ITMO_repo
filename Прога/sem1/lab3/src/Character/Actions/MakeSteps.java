package src.Character.Actions;

import src.Character.BasicCharacter;
import src.Character.Actions.Exceptons.NegativeEnergyException;
import src.Character.Actions.Exceptons.NegativePotatoesException;
import src.Character.Actions.StepsEnums.StepStatus;
import src.Character.CharacterMethods.CharacterEnergy;
import src.Character.CharacterMethods.CharacterName;
import src.Clothes.Cloth;

public class MakeSteps {
    private final CharacterEnergy energy;
    private final CharacterName name;
    public MakeSteps(CharacterEnergy energy, CharacterName name) {
        this.energy = energy;
        this.name = name;
    }

    // make step (potatoes + energy)
    private StepStatus makePotatoStep(Cloth cloth) {
        try { cloth.makeStep(); }
        catch (NegativePotatoesException e){
            System.out.print("В какой-то момент " +
                    name.getName() +
                    " ощутил необычайную лёгкость и решил проверить карманы. Он обнаружил, что из прорех вывалился весь картофель, "
            );
            return StepStatus.NOT_ENOUGH_POTATOES;
        }
        return StepStatus.OK;
    }
    private StepStatus makeEnergyStep() {
        try { energy.energyStepIncriment(); }
        catch (NegativeEnergyException e){
            System.out.print("В какой-то момент он окончательно выбился из сил, сел посреди поля и стал ожидать чего-то, сам не зная чего. ");
            return StepStatus.NOT_ENOUGH_ENERGY;
        }

        return StepStatus.OK;
    }
    public StepStatus makeStep(Cloth cloth) {
        StepStatus potatoStepStatus = this.makePotatoStep(cloth);
        if (potatoStepStatus != StepStatus.OK){ return potatoStepStatus; }

        return this.makeEnergyStep();
    }
    // make step (energy)
    public StepStatus makeStepAfterReclaim(){
        StepStatus energyStepStatus = this.makeEnergyStep();
        if (energyStepStatus != StepStatus.OK){ return energyStepStatus; }

        if (energy.getEnergy() == 0) return StepStatus.LAST_STEP;
        return StepStatus.OK;
    }
}
