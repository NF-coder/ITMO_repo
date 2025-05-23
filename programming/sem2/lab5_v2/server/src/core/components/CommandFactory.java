package server.core.components;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import server.network.container.NetworkContainer;
import server.storage.collection.drivers.IStructDriver;
import server.storage.commands.CommandsManager;
import shared.objects.NetworkRequestDTO;

public class CommandFactory {
    private final CommandsManager commandsManager;

    public CommandFactory(IStructDriver structDriver) {
        this.commandsManager = new CommandsManager(
                structDriver
        );
    }

    public <R> CompletableFuture<NetworkContainer<HashMap<String,String>, R>> run(
            NetworkContainer<NetworkRequestDTO, R> data
    ) {
        return commandsManager.run(
                data.data().opName(),
                data.data().args()
        ).thenApply(
                res -> new NetworkContainer<>(data.connInfo(), res)
        );
    }
}
