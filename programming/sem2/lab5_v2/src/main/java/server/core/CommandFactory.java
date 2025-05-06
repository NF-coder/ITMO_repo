package server.core;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

import server.storage.collection.drivers.IStructDriver;
import server.storage.commands.CommandsManager;

public class CommandFactory {
    private final ExecutorService executor;
    private final CommandsManager commandsManager;

    public CommandFactory(ExecutorService executor, IStructDriver structDriver) {
        this.commandsManager = new CommandsManager(
                structDriver
        );
        this.executor = executor;
    }

    public <T> void runCommand(
            String opName,
            HashMap<String, String> args,
            Function<HashMap<String,String>, T> nextStage
    ) {
        commandsManager.run(
                opName,
                args,
                this.executor
        ).thenApply(
                nextStage
        );
    }
}
