package commands;

import storage.Structure;

import java.util.HashMap;

public class Clear extends BasicCommand{
    public Clear(){
        super("clear", "Clears all information about collection.");
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();
        structure.clearCollection();
        System.out.println("Success");
    }
}
