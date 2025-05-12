package client.commands.implementations;

import java.util.HashMap;

import client.commands.BasicCommand;
import client.core.Engine;
import client.network.NetworkManager;

public class Help extends BasicCommand {
    public Help(){
        super("help", "Returns information about all commands.");
    }

    public final void execute(HashMap<String, String> args, Engine engine) {
        for (BasicCommand command : Engine.getCommands()) {
            System.out.println(command.getName() + " - " + command.getInfo());
        }
    }
}
