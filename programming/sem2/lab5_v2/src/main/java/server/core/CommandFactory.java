package server.core;

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

import server.network.container.NetworkContainer;
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

    public CompletableFuture<NetworkContainer<HashMap<String,String>>> runCommand(
            String opName,
            HashMap<String, String> args,
            SocketAddress socketAddress
    ) {
        return commandsManager.run(
                opName,
                args,
                this.executor
        ).thenApply(
                res -> new NetworkContainer<>(socketAddress, res)
        );
    }
}
