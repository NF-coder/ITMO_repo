package src.Character;

import src.Clothes.Cloth;
import src.IBasicObj;

public abstract class BasicCharacter implements IBasicObj {
    private final String name;
    private final int id;
    protected Cloth cloth;
    private int energy;
    private int potatoes;

    // init
    public BasicCharacter(String name) {
        this.name = name;
        this.id = 1;
    }

    // Cloth getter/setter
    public void setCloth(Cloth cloth){ this.cloth = cloth; }
    public Cloth getCloth(){ return this.cloth; }

    // Energy getter/setter
    public void setEnergy(int energy) { this.energy = energy; }
    public int getEnergy(){ return this.energy; }

    // Potatoes getter/setter
    public void setPotatoes(int potatoes) { this.potatoes = potatoes; }
    public int getPotatoes(){ return this.potatoes; }

    // IBasicObj getters
    public String getName(){ return this.name; }
    public int getId(){ return this.id; }

    public void throwPotatoes(){
        this.setPotatoes(0);
        System.out.println(this.getName() + " швырнул картофель в сторону.");
    }

}
