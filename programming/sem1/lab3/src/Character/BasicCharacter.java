package src.Character;

import src.Clothes.Cloth;
import src.IBasicObj;

public abstract class BasicCharacter implements IBasicObj {
    private final String name;
    private final int id;
    protected Cloth cloth;
    private int energy;

    // init
    public BasicCharacter(String name) {
        this.name = name;
        this.id = 1;
    }

    // Cloth setter
    public void setCloth(Cloth cloth){
        this.cloth = cloth;
    }

    // Energy getter/setter + increment
    public void setEnergy(int energy){
        this.energy = energy;
    }
    public int getEnergy(){
        return this.energy;
    }
    public void makeEnergyStep(){
        this.energy -= 1;
    }

    // IBasicObj getters
    public String getName(){ return this.name; }
    public int getId(){ return this.id; }

}
