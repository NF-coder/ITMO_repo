package server.core.factories;

import java.util.concurrent.ExecutorService;

import server.core.Engine;
import server.network.drivers.INetworkDriver;
import server.network.managers.ReceiveManager;
import server.network.serializers.INetworkDeserialize;
import server.network.serializers.INetworkSerializers;

public class RequestFactory<T> {
    private final ReceiveManager<T> receiveManager;
    private final ExecutorService executor;
    private final Engine engine;

    public RequestFactory(INetworkDriver networkDriver, INetworkDeserialize<T> serializer, ExecutorService executor, Engine engine) {
        this.receiveManager = new ReceiveManager<>(
                networkDriver,
                serializer
        );
        this.executor = executor;
        this.engine = engine;
    }

    public void run() {
        executor.submit(() -> {
           while (true) {
               engine.mainCycle(
                       receiveManager.call().get()
               );
           }
        });
    }
}
