package server.core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import server.core.components.CommandFactory;
import server.core.components.RequestSupplier;
import server.core.components.ResponseConsumer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import server.storage.collection.drivers.IStructDriver;

public class Engine{
    public <T> Engine(
            INetworkDriver<T> networkDriver,
            ExecutorService receiveExecutor,
            ExecutorService sendExecutor,
            ExecutorService commandExecutor,
            INetworkSerializers networkSerializer,
            IStructDriver structDriver
    ) {
        try {
            networkDriver.init();
        } catch (Exception ignored) {}

        CommandFactory cf = new CommandFactory(structDriver);
        ResponseConsumer rc = new ResponseConsumer(
                networkDriver::send,
                networkSerializer::serialize
        );
        RequestSupplier<T> rs = new RequestSupplier<>(
                networkDriver::receive,
                networkSerializer::deserialize,
                receiveExecutor,
                (data) ->  CompletableFuture
                        .supplyAsync(() -> data)
                        .thenComposeAsync(
                                cf::run,
                                commandExecutor
                        )
                        .thenComposeAsync(
                                rc::run,
                                sendExecutor
                        )
        );

        rs.run();
    }
}
