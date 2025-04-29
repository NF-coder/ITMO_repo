package server.core;

import server.network.NetworkCycle;
import server.network.objects.NetworkDTO;
import server.network.drivers.implementations.UDPDriver;
import server.storage.collection.drivers.IStructDriver;
import server.storage.collection.drivers.implementations.DequeDriver;
import server.storage.commands.CommandsManager;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Engine {
    private final Queue<NetworkDTO> networkReceived = new ArrayDeque<>();
    private final Queue<String> networkToSend = new ArrayDeque<>();

    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private final IStructDriver sd = new DequeDriver();
    private final CommandsManager cm = new CommandsManager(sd);

    public Engine(){
        Thread networkThread = new Thread(
                new NetworkCycle(
                    new UDPDriver(4056),
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
                NetworkDTO networkDTO = networkReceived.remove();

                Future<Object> future = cm.run(
                        networkDTO.opName(),
                        networkDTO.args(),
                        this.executor
                );
                networkToSend.add(future);
            }
            if (!this.finalizedPromises.isEmpty()){
                System.out.println("Received from fin");
                this.networkToSend.add(
                        this.finalizedPromises.get()
                );
                System.out.println(networkToSend.size());
            }
        }
        catch (Exception e){

        }
    }
}
