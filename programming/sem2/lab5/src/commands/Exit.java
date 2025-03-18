package commands;

import java.util.HashMap;

public class Exit extends BasicCommand{
    public Exit(){
        super("exit", "Finishes CLI without saving collection to file");
    }

    public final void execute(HashMap<String, String> args){
        System.exit(0);
    }
}
