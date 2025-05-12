package server.core.factories;

import org.json.JSONObject;
import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.managers.SendManager;
import server.network.serializers.INetworkSerialize;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkResponseDTO;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class ResponseFactory<T> {
    private final SendManager<T> sendManager;

    public ResponseFactory(INetworkDriver networkDriver, INetworkSerialize<T> serializer) {
        this.sendManager = new SendManager<>(
                networkDriver,
                serializer
        );
    }

    public CompletableFuture<Void> run(
            NetworkContainer<NetworkResponseDTO<T>> data
    ) {
        return CompletableFuture.supplyAsync(
                () -> new NetworkContainer<>(
                    data.socketAddress(),
                    new NetworkResponseDTO<>(data.data().toString())
                )
        ).thenCompose(
                sendManager::call
        );
    }
}
