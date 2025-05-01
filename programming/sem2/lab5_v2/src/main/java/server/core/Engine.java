package server.core;

import server.network.NetworkCycle;
import server.network.serializers.implementations.BinarySerializer;
import shared.objects.NetworkRequestDTO;
import server.network.drivers.implementations.UDPDriver;
import shared.objects.NetworkResponseDTO;
import server.storage.collection.drivers.implementations.DequeDriver;
import server.storage.commands.CommandsManager;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Engine {
    private final Queue<NetworkRequestDTO> networkReceived = new ArrayDeque<>();
    private final Queue<NetworkResponseDTO> networkToSend = new ArrayDeque<>();

    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private final CommandsManager cm = new CommandsManager(
            new DequeDriver()
    );

    public Engine(){
        Thread networkThread = new Thread(
                new NetworkCycle(
                    new UDPDriver(4056),
                    new BinarySerializer(),
                    this.networkReceived,
                    this.networkToSend
            )
        );
        networkThread.start();
    }

    public void mainCycle(){
        try{
            Thread.sleep(1);
            if (!networkReceived.isEmpty()){
                System.out.println("Received from get");
                NetworkRequestDTO networkRequestDTO = networkReceived.remove();
                System.out.println(networkRequestDTO);

                CompletableFuture<HashMap<String,String>> future = cm.run(
                        networkRequestDTO.opName(),
                        networkRequestDTO.args(),
                        this.executor
                );
                future.thenApply(
                        res->{
                            System.out.println("fapl: " + res.toString());
                            return networkToSend.add(
                                    new NetworkResponseDTO(res)
                            );
                        }
                );

            }
        }
        catch (Exception e){
            System.out.println("eng " + e.getMessage());
        }
    }
}
