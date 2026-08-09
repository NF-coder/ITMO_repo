package core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import core.components.CommandFactory;
import core.components.RequestSupplier;
import core.components.ResponseConsumer;
import network.drivers.INetworkDriver;
import network.serializers.INetworkSerializers;
import storage.collection.drivers.IStructDriver;

/**
 * Движок сервера
 */
public class Engine{
    public <T> Engine(
            INetworkDriver<T> networkDriver,
            ExecutorService receiveExecutor,
            ExecutorService sendExecutor,
            ExecutorService commandExecutor,
            INetworkSerializers networkSerializer,
            IStructDriver structDriver
    ) {
        System.out.println("Starting Engine");
        try {
            networkDriver.init();
        } catch (Exception ignored) {}

        CommandFactory cf = new CommandFactory(structDriver);
        ResponseConsumer<T> rc = new ResponseConsumer<>(
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

        System.out.println("Engine initialized");

        rs.run();
    }
}
