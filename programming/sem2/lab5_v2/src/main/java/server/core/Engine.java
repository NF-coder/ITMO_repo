package server.core;

import java.util.concurrent.ExecutorService;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.managers.ReceiveManager;
import server.network.managers.SendManager;
import server.network.serializers.INetworkSerializers;
import server.storage.collection.drivers.IStructDriver;
import shared.objects.NetworkResponseDTO;

public class Engine {
    private final ReceiveManager receiveManager;
    public final SendManager sendManager;
    private final CommandFactory commandFactory;

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

        this.receiveManager = new ReceiveManager(
                networkDriver,
                networkSerializer,
                receiveExecutor
        );
        this.sendManager = new SendManager(
                networkDriver,
                networkSerializer,
                sendExecutor
        );
        this.commandFactory = new CommandFactory(
                commandExecutor,
                structDriver
        );
    }

    public void mainCycle() {
        try {
            receiveManager.call()
                    .thenCompose(
                            networkRequestDTO -> commandFactory.runCommand(
                                    networkRequestDTO.data().opName(),
                                    networkRequestDTO.data().args(),
                                    networkRequestDTO.socketAddress()
                            )
                    )
                    .thenCompose(
                            result -> sendManager.call(
                                    new NetworkContainer<>(
                                            result.socketAddress(),
                                            new NetworkResponseDTO(result.data())
                                    )
                            )
                    );
        } catch (Exception e) {
            System.out.println("eng " + e.getMessage());
        }
    }
}
