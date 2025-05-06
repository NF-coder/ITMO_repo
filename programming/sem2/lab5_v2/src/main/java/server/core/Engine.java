package server.core;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;

import server.network.container.NetworkContainer;
import server.network.NetworkCycle;
import server.network.drivers.implementations.UDPDriver;
import server.network.serializers.implementations.BinarySerializer;
import server.storage.collection.drivers.implementations.DequeDriver;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

public class Engine {
    private final Queue<NetworkContainer<NetworkRequestDTO>> networkReceived = new ConcurrentLinkedQueue<>();
    private final Queue<NetworkContainer<NetworkResponseDTO>> networkToSend = new ConcurrentLinkedQueue<>();

    private final CommandFactory commandFactory = new CommandFactory(
            Executors.newFixedThreadPool(10),
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
            if (!networkReceived.isEmpty()){
                System.out.println("Received from get");
                NetworkContainer<NetworkRequestDTO> networkRequestDTO = networkReceived.remove();
                System.out.println(networkRequestDTO);

                commandFactory.runCommand(
                        networkRequestDTO.data().opName(),
                        networkRequestDTO.data().args(),
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
