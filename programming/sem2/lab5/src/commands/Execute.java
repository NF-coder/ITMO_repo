package commands;

import exceptions.FileProcessorException;
import textWorkers.Invokers.FileInvoker;

import java.util.HashMap;

public class Execute extends BasicCommand {
    public Execute() {
        super("execute_script", "Takes commands from file." +
                "\n\t Example: execute_script -filename [String]");
    }

    public final void execute(HashMap<String, String> args) {
        FileInvoker invoker = new FileInvoker();
        invoker.mainCycle();
    }
}