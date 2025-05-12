package server.core.factories;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;
import server.network.container.NetworkContainer;
import server.storage.collection.drivers.IStructDriver;
import server.storage.commands.CommandsManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

public class CommandFactory {
    private final CommandsManager commandsManager;

    public CommandFactory(IStructDriver structDriver) {
        this.commandsManager = new CommandsManager(
                structDriver
        );
    }

    public CompletableFuture<NetworkContainer<JSONObject>> run(
            NetworkContainer<NetworkRequestDTO> data
    ) {
        return commandsManager.run(
                data.data().opName(),
                data.data().args()
        ).thenApply(
                res -> new NetworkContainer<>(data.socketAddress(), res)
        );
    }
}
