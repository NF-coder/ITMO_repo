package src.Character;

import src.Clothes.Cloth;
import src.IBasicObj;
import src.Locations.Location;

import java.util.Objects;

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
    public void setPotatoes(int potatoes) {
        if (potatoes < 0){throw new NegativePotatoesException();}
        this.potatoes = potatoes;
    }
    public int getPotatoes(){ return this.potatoes; }

    // IBasicObj getters
    public String getName(){ return this.name; }
    public int getId(){ return this.id; }

    public void throwPotatoes(){
        this.setPotatoes(0);
        System.out.print(this.getName() + " швырнул картофель в сторону. ");
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getEnergy(), this.getPotatoes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicCharacter character = (BasicCharacter) o;
        return this.getName().equals(character.getName()) &&
                this.getCloth().equals(character.getCloth()) &&
                this.getEnergy() == character.getEnergy() &&
                this.getPotatoes() == character.getPotatoes();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name=" + this.getName() +
                ", energy=" + this.getEnergy() +
                ", potatoes=" + this.getPotatoes() +
                ", cloth=" + this.getCloth() +
                '}';
    }
}
