package server.network.managers;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkDeserialize;
import server.network.serializers.INetworkSerialize;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;

public class ReceiveManager<T>{
    private final INetworkDriver driver;
    private final INetworkDeserialize<T> serializer;

    public ReceiveManager(INetworkDriver driver, INetworkDeserialize<T> serializer) {
        this.driver = driver;
        this.serializer = serializer;
    }

    public CompletableFuture<NetworkContainer<T>> call() throws IOException, ClassNotFoundException {
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        return this.driver.receive();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
        ).thenApply(
                res -> {
                    try {
                        return new NetworkContainer<>(
                                res.socketAddress(),
                                this.serializer.apply(
                                        res.data()
                                ));
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

    }
}