package server.core;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.network.NetworkContainer;
import server.network.NetworkCycle;
import server.network.drivers.implementations.UDPDriver;
import server.network.serializers.implementations.BinarySerializer;
import server.storage.collection.drivers.implementations.DequeDriver;
import server.storage.commands.CommandsManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

public class Engine {
    private final Queue<NetworkContainer<NetworkRequestDTO>> networkReceived = new ConcurrentLinkedQueue<>();
    private final Queue<NetworkContainer<NetworkResponseDTO>> networkToSend = new ConcurrentLinkedQueue<>();

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
            //Thread.sleep(1);
            //System.out.println(networkReceived.size());
            if (!networkReceived.isEmpty()){
                System.out.println("Received from get");
                NetworkContainer<NetworkRequestDTO> networkRequestDTO = networkReceived.remove();
                System.out.println(networkRequestDTO);

                CompletableFuture<HashMap<String,String>> future = cm.run(
                        networkRequestDTO.data().opName(),
                        networkRequestDTO.data().args(),
                        this.executor
                );
                future.thenApply(
                        res->{
                            System.out.println("fapl: " + res.toString());
                            return networkToSend.add(
                                    new NetworkContainer<>(
                                            networkRequestDTO.socketAddress(),
                                            new NetworkResponseDTO(res)
                                    )
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
