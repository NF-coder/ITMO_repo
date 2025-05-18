package client.commands.implementations;

import client.commands.BasicCommand;
import client.commands.exceptions.FileProcessorException;
import client.core.Engine;
import client.network.NetworkManager;
import client.textWorkers.Invokers.FileInvoker;


import java.util.HashMap;
import java.util.function.Consumer;

public class Execute extends BasicCommand {
    public Execute(Consumer<HashMap<String,String>> outHandler) {
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