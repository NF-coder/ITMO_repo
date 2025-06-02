package commands.implementations;

import java.util.HashMap;
import java.util.function.Consumer;

import commands.BasicCommand;
import core.Engine;
import org.json.JSONObject;

public class Help extends BasicCommand {
    public Help(Consumer<JSONObject> outHandler){
        super("help", "Returns information about all commands.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) {
        for (BasicCommand command : engine.getCommands()) {
            System.out.println(command.getName() + " - " + command.getInfo());
        }
    }
}
