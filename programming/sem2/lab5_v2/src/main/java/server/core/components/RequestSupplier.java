package server.core.components;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

import server.network.container.NetworkContainer;
import server.network.drivers.NetDriverReceive;
import server.network.managers.ReceiveManager;
import server.network.serializers.INetworkDeserializer;
import shared.objects.NetworkRequestDTO;

public class RequestSupplier<T> {
    private final ReceiveManager<T> receiveManager;
    private final ExecutorService executor;
    private final Consumer<NetworkContainer<NetworkRequestDTO, T>> pipeline;

    public RequestSupplier(NetDriverReceive<T> networkDriver, INetworkDeserializer serializer, ExecutorService executor, Consumer<NetworkContainer<NetworkRequestDTO, T>> engine) {
        this.receiveManager = new ReceiveManager<>(
                networkDriver,
                serializer
        );
        this.executor = executor;
        this.pipeline = engine;
    }

    public void run() {
        executor.submit(() -> {
           while (true) {
               pipeline.accept(
                       receiveManager.call().get()
               );
           }
        });
    }
}
