package server.network.managers;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;

public class ReceiveManager {
    private final INetworkDriver driver;
    private final INetworkSerializers serializer;

    public ReceiveManager(INetworkDriver driver, INetworkSerializers serializer) {
        this.driver = driver;
        this.serializer = serializer;
    }

    public CompletableFuture<NetworkContainer<NetworkRequestDTO>> call() throws IOException, ClassNotFoundException {
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
                                this.serializer.deserialize(
                                        res.data()
                                ));
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

    }
}