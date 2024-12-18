package src.Locations;

import src.IBasicObj;

import java.util.Random;

public abstract class Location implements IBasicObj {
    private int id;
    private final String name;
    private final Random rnd = new Random();

    public Location(String name) {
        this.name = name;
    }

    public rootSelection(String)

    public String getName(){return name;}
    public int getId(){return id;}
}
