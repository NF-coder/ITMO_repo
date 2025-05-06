package server.network.managers;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReceiveManager {
    INetworkDriver driver;
    INetworkSerializers serializer;
    ExecutorService executor;

    public ReceiveManager(INetworkDriver driver, INetworkSerializers serializer, ExecutorService executor) {
        this.driver = driver;
        this.serializer = serializer;
        this.executor = executor;
    }

    public CompletableFuture<NetworkContainer<NetworkRequestDTO>> call() throws IOException, ClassNotFoundException{
        return  CompletableFuture.supplyAsync(() -> {
            try {
                return this.driver.receive();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).thenApply(
                res -> {
                    try {
                        return new NetworkContainer<>(
                                res.socketAddress(),
                                this.serializer.deserialize(
                                        res.data()
                                )
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}