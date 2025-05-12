package server.network.managers;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkResponseDTO;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class SendManager {
    INetworkDriver driver;
    INetworkSerializers serializer;

    public SendManager(INetworkDriver driver, INetworkSerializers serializer) {
        this.driver = driver;
        this.serializer = serializer;
    }

    public CompletableFuture<Void> call(NetworkContainer<NetworkResponseDTO> elem){
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        return this.serializer.serialize(
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
