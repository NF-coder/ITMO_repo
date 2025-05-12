package server.core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import server.core.factories.CommandFactory;
import server.core.factories.RequestFactory;
import server.core.factories.ResponseFactory;
import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import server.storage.collection.drivers.IStructDriver;
import shared.objects.NetworkRequestDTO;

public class Engine {

    private final CommandFactory commandFactory;
    private final ResponseFactory responseFactory;
    private final RequestFactory requestFactory;

    private final ExecutorService commandExecutor;
    private final ExecutorService sendExecutor;

    public Engine(
            INetworkDriver networkDriver,
            ExecutorService receiveExecutor,
            ExecutorService sendExecutor,
            ExecutorService commandExecutor,
            INetworkSerializers networkSerializer,
            IStructDriver structDriver
    ) {
        try {
            networkDriver.init();
        } catch (Exception ignored) {}

        this.commandExecutor = commandExecutor;
        this.sendExecutor = sendExecutor;

        this.commandFactory = new CommandFactory(structDriver);
        this.responseFactory = new ResponseFactory(networkDriver, networkSerializer);
        this.requestFactory = new RequestFactory(networkDriver, networkSerializer, receiveExecutor, this);
    }
    public void start(){
        this.requestFactory.run();
    }

    public void mainCycle(NetworkContainer<NetworkRequestDTO> data) {
        CompletableFuture
                .supplyAsync(() -> data)
                .thenComposeAsync(
                        commandFactory::run,
                        commandExecutor
                )
                .thenComposeAsync(
                        responseFactory::run,
                        sendExecutor
                );
    }
}
