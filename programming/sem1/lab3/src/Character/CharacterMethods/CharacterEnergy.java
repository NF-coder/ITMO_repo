package src.Character.CharacterMethods;

import src.Character.Actions.Exceptons.NegativeEnergyException;

public class CharacterEnergy {
    private int energy;

    // Energy getter/setter
    public void setEnergy(int energy){ this.energy = energy; }
    public int getEnergy(){ return this.energy; }
    public void energyStepIncriment() throws NegativeEnergyException {
        if (energy == 0) {throw new NegativeEnergyException();}
        this.setEnergy(this.getEnergy()-1);
    }
}
