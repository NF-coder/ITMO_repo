package server.core.factories;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.managers.SendManager;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkResponseDTO;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class ResponseFactory {
    private final SendManager sendManager;

    public ResponseFactory(INetworkDriver networkDriver, INetworkSerializers serializer) {
        this.sendManager = new SendManager(
                networkDriver,
                serializer
        );
    }

    public CompletableFuture<Void> run(
            NetworkContainer<HashMap<String,String>> data
    ) {
        return CompletableFuture.supplyAsync(
                () -> new NetworkContainer<>(
                    data.socketAddress(),
                    new NetworkResponseDTO(data.data())
                )
        ).thenCompose(
                sendManager::call
        );
    }
}
