package commands;

import core.Structure;

import java.util.HashMap;

public class Info extends BasicCommand{
    public Info(){
        super("info", "Returns information about Collection.");
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();
        System.out.println(structure);
    }
}
