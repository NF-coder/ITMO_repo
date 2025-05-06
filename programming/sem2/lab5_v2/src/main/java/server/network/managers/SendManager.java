package server.network.managers;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SendManager {
    INetworkDriver driver;
    INetworkSerializers serializer;
    ExecutorService executor;

    public SendManager(INetworkDriver driver, INetworkSerializers serializer) {
        this.driver = driver;
        this.serializer = serializer;
        this.executor = Executors.newFixedThreadPool(1);
    }

    public void call(Queue<NetworkContainer<NetworkResponseDTO>> outQueue) throws Exception{
        NetworkContainer<NetworkResponseDTO> elem = outQueue.poll();
        if(elem == null){return;}

        CompletableFuture.supplyAsync(
                () -> {
                    try {
                        return this.serializer.serialize(
                                elem.data()
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                },
                executor
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
