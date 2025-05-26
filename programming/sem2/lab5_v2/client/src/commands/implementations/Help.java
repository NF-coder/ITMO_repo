package commands.implementations;

import java.util.HashMap;
import java.util.function.Consumer;

import commands.BasicCommand;
import core.Engine;

public class Help extends BasicCommand {
    public Help(Consumer<HashMap<String,String>> outHandler){
        super("help", "Returns information about all commands.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) {
        for (BasicCommand command : engine.getCommands()) {
            System.out.println(command.getName() + " - " + command.getInfo());
        }
    }
}
