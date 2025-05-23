package commands.implementations;

import commands.BasicCommand;
import core.Engine;

import java.util.HashMap;

public class Exit extends BasicCommand {
    public Exit(){
        super("exit", "Finishes CLI without saving collection to file");
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) {
        System.exit(0);
    }
}
