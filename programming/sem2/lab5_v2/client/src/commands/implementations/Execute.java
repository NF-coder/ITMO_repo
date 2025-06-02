package commands.implementations;

import commands.BasicCommand;
import commands.exceptions.FileProcessorException;
import core.Engine;
import org.json.JSONObject;
import textWorkers.Invokers.FileInvoker;


import java.util.HashMap;
import java.util.function.Consumer;

public class Execute extends BasicCommand {
    public Execute(Consumer<JSONObject> outHandler) {
        super("execute_script", "Takes commands from file." +
                "\n\t Example: execute_script -filename [String]",
                outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) {
        try {
            engine.setInvoker(new FileInvoker(args.get("filename")));
        } catch (FileProcessorException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.out.println("Выполнение скрипта завершено!");;
        }
    }
}