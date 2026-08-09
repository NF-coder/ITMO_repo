package src.Clothes;
import src.Character.Actions.Exceptons.NegativePotatoesException;
import src.IBasicObj;
import src.Objects.Potato;
import src.Random.RandomWrapper;

import java.util.ArrayList;
import java.util.Objects;

public class Cloth implements IBasicObj {
    private final String name;
    private final int id;
    private final int stepIncrement;
    private final ArrayList<Potato> potatoes = new ArrayList<Potato>();
    private final RandomWrapper rnd = new RandomWrapper();

    public Cloth(String name, int stepIncrement) {
        this.name = name;
        this.id = 1;
        this.stepIncrement = stepIncrement;
    }

    public void setPotatoes(int potatoes) throws NegativePotatoesException {
        if (potatoes < 0){throw new NegativePotatoesException();}
        for (int i = potatoes; i > 0; i--) {
            this.potatoes.add(rnd.randomizePotato());
        }
    }
    private ArrayList<Potato> getPotatoes() {return this.potatoes;}
    public int getPotatoesCount(){ return this.getPotatoes().size(); }
    public void makeStep()  throws NegativePotatoesException {
        if (this.getPotatoes().size()-this.getStepIncrement() < 0){throw new NegativePotatoesException();}
        for (int i = this.getStepIncrement(); i > 0; i--) {
            this.getPotatoes().remove(0);
        }
    }

    public int getStepIncrement(){
        return this.stepIncrement;
    }

    // IBasicObj getters
    public String getName(){ return this.name; }
    public int getId(){ return this.id; }


    // (String name, int stepIncriment)
    @Override
    public int hashCode() {
        return Objects.hash(
                this.getName(),
                this.getStepIncrement(),
                this.getPotatoesCount()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cloth cloth = (Cloth) o;
        return this.getName().equals(cloth.getName()) &&
                this.getStepIncrement() == cloth.getStepIncrement() &&
                this.getPotatoesCount() == cloth.getPotatoesCount() &&
                this.getPotatoes().equals(cloth.getPotatoes());
    }

    @Override
    public String toString() {
        return "Location{" +
                "name=" + this.getName() +
                ", stepIncrement=" + this.getStepIncrement() +
                ", potatoes=" + this.getPotatoes() +
                '}';
    }
}
