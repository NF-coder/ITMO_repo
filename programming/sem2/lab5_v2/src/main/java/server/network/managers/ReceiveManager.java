package server.network.managers;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class ReceiveManager {
    INetworkDriver driver;
    INetworkSerializers serializer;
    ExecutorService executor;

    public ReceiveManager(INetworkDriver driver, INetworkSerializers serializer, ExecutorService executor) {
        this.driver = driver;
        this.serializer = serializer;
        this.executor = executor;
    }

    public CompletableFuture<NetworkContainer<NetworkRequestDTO>> call() throws IOException, ClassNotFoundException {
        return CompletableFuture.supplyAsync(
                () -> {
                    while (true){
                        try {
                            NetworkContainer<byte[]> tmp = this.driver.receive();
                            if (tmp != null){return tmp;}
                        } catch (IOException ignored) {}
                    }
                },
                executor
        ).thenApply(
                res -> {
                    try {
                        return new NetworkContainer<>(
                                res.socketAddress(),
                                this.serializer.deserialize(
                                        res.data()
                                )
                        );
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}