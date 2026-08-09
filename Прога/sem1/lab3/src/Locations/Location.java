package src.Locations;

import src.IBasicObj;
import src.Locations.FieldMethods.FieldLenght;
import src.Random.RandomWrapper;
import java.util.Objects;
import src.Character.BasicCharacter;

public abstract class Location implements IBasicObj {
    private int id;
    private final String name;
    private BasicCharacter character;
    protected final RandomWrapper rnd = new RandomWrapper();

    public Location(String name, BasicCharacter character) {
        this.name = name;
        this.setCharacter(character);
    }

    private void setCharacter(BasicCharacter character){this.character = character;}
    protected BasicCharacter getCharacter(){return this.character;}

    abstract public void execute();

    public String getName(){return name;}
    public int getId(){return id;}

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location loc = (Location) o;
        return getName().equals(loc.getName()) && getCharacter().equals(loc.getCharacter());
    }

    @Override
    public String toString() {
        return "Location{" +
                "name=" + this.getName() +
                ", character=" + this.getCharacter() +
                '}';
    }
}
