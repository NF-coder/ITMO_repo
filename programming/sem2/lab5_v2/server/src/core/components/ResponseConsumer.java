package core.components;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import network.container.NetworkContainer;
import network.drivers.NetDriverSend;
import network.managers.SendManager;
import network.serializers.INetworkSerializer;
import org.json.JSONObject;
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
            NetworkContainer<JSONObject, T> data
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
