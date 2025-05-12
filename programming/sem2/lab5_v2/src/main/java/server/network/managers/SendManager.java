package server.network.managers;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkDeserialize;
import server.network.serializers.INetworkSerialize;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkResponseDTO;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public class SendManager <T> {
    private final INetworkDriver driver;
    private final INetworkSerialize<T> serializer;

    public SendManager(INetworkDriver driver, INetworkSerialize<T> serializer) {
        this.driver = driver;
        this.serializer = serializer;
    }

    public CompletableFuture<Void> call(NetworkContainer<T> elem){
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        return this.serializer.apply(
                                elem.data()
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).thenAccept(
                res -> {
                    try {
                        this.driver.send(
                                new NetworkContainer<> (
                                        elem.socketAddress(),
                                        res
                                )
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
