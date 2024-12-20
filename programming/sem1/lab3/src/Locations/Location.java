package src.Locations;

import src.Character.BasicCharacter;
import src.IBasicObj;

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
}
