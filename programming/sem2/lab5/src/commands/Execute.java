package commands;

import core.Engine;
import exceptions.FileProcessorException;
import textWorkers.invokers.CLInvoker;
import textWorkers.invokers.FileInvoker;

import java.util.HashMap;

public class Execute extends BasicCommand {
    public Execute() {
        super("execute_script", "Takes commands from file." +
                "\n\t Example: execute_script -abspath [String]");
    }

    public final void execute(HashMap<String, String> args){
        try {
            Engine.setActiveInvoker(new FileInvoker(args.get("abspath")));
            new Engine().start();

        }
        catch (FileProcessorException exc){
            System.out.print("fpe ");
            System.out.println(exc);
        }
        finally {
            Engine.setActiveInvoker(new CLInvoker());
        }
    }
}