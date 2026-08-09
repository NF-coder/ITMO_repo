package core.components;

import java.util.concurrent.CompletableFuture;

import network.container.NetworkContainer;
import org.json.JSONObject;
import storage.collection.drivers.IStructDriver;
import storage.commands.CommandsManager;
import shared.objects.NetworkRequestDTO;

public class CommandFactory {
    private final CommandsManager commandsManager;

    public CommandFactory(IStructDriver structDriver) {
        this.commandsManager = new CommandsManager(
                structDriver
        );
    }

    public <R> CompletableFuture<NetworkContainer<JSONObject, R>> run(
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
