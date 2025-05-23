package server.core.components;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import server.network.container.NetworkContainer;
import server.network.drivers.NetDriverSend;
import server.network.managers.SendManager;
import server.network.serializers.INetworkSerializer;
import shared.objects.NetworkResponseDTO;

public class ResponseConsumer<T> {
    private final SendManager<T> sendManager;

    public ResponseConsumer(NetDriverSend<T> networkDriver, INetworkSerializer serializer) {
        this.sendManager = new SendManager<>(
                networkDriver,
                serializer
        );
    }

    public CompletableFuture<Void> run(
            NetworkContainer<HashMap<String,String>, T> data
    ) {
        return CompletableFuture.supplyAsync(
                () -> new NetworkContainer<>(
                    data.connInfo(),
                    new NetworkResponseDTO(data.data())
                )
        ).thenCompose(
                sendManager::call
        );
    }
}
