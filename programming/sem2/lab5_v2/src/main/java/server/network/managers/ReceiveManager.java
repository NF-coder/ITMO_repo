package server.network.managers;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReceiveManager {
    INetworkDriver driver;
    INetworkSerializers serializer;
    ExecutorService executor;

    public ReceiveManager(INetworkDriver driver, INetworkSerializers serializer) {
        this.driver = driver;
        this.serializer = serializer;
        this.executor = Executors.newFixedThreadPool(1);
    }

    public void call(Queue<NetworkContainer<NetworkRequestDTO>> inpQueue) throws IOException, ClassNotFoundException{
        try {
            NetworkContainer<byte[]> nc = this.driver.receive();
            inpQueue.add(
                    new NetworkContainer<>(
                            nc.socketAddress(),
                            this.serializer.deserialize(
                                    nc.data()
                            )
                    )
            );
        }
        catch (Exception e){}
    }
}