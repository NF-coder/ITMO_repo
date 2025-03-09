package commands;

import java.util.HashMap;

import commands.BasicCommand;

import commands.Info;
import workers.Engine;

public class Help extends BasicCommand{
    public Help(){
        super("help", "Returns information about all commands.");
    }

    public final void execute(HashMap<String, String> args){
        for (BasicCommand command : Engine.getCommands()) {
            System.out.println(command.getName() + " - " + command.getInfo());
        }
    }
}
