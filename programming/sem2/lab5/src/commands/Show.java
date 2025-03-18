package commands;

import core.Structure;

import java.util.HashMap;

public class Show extends BasicCommand{
    public Show(){
        super("show", "Shows all entities from collection.");
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();
        System.out.println(structure.getAllEntities());
    }
}
