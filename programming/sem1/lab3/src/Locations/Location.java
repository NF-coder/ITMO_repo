package src.Locations;

import src.Character.BasicCharacter;
import src.IBasicObj;
import java.util.Objects;
import java.util.Random;

public abstract class Location implements IBasicObj {
    private int id;
    private final String name;
    protected final Random rnd = new Random();
    private BasicCharacter character;

    public Location(String name, BasicCharacter character) {
        this.name = name;
        this.setCharacter(character);
    }

    private void setCharacter(BasicCharacter character){this.character = character;}
    protected BasicCharacter getCharacter(){return this.character;}

    abstract public Location run();

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
