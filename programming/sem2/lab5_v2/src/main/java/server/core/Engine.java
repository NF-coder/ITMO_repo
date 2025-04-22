package server.core;

import server.core.promise.FinalizedPromises;
import server.network.NetworkCycle;
import server.storage.StorageCycle;
import server.network.objects.NetworkDTO;
import server.network.drivers.UDPDriver;
import server.storage.control.IStorageController;
import server.storage.control.StorageQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Engine {
    private final IStorageController SAC;
    private final FinalizedPromises finalizedPromises;
    private final Queue<NetworkDTO> networkReceived = new ArrayDeque<>();
    private final Queue<Object> networkToSend = new ArrayDeque<>();

    public Engine(){
        Thread networkThread = new Thread(
                new NetworkCycle(
                    new UDPDriver(4055),
                    this.networkReceived,
                    this.networkToSend
            )
        );
        networkThread.start();

        this.finalizedPromises = new FinalizedPromises();
        this.SAC = new StorageQueue(this.finalizedPromises);

        Thread storageThread = new Thread(
                new StorageCycle(this.SAC)
        );
        storageThread.start();
    }

    public void mainCycle(){
        try{
            if (!networkReceived.isEmpty()){
                System.out.println("Received from get");
                NetworkDTO in = this.networkReceived.remove();
                SAC.add(in.opName(), in.args());
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
