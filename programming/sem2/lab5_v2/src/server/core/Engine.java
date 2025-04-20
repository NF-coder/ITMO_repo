package server.core;

import server.core.promise.FinalizedPromises;
import server.storage.StorageCycle;
import server.core.promise.Promise;
import server.network.NetworkDTO;
import server.network.NetworkManager;
import server.network.drivers.UDPDriver;
import server.storage.control.IStorageController;
import server.storage.control.Queue;

public class Engine {
    private final NetworkManager network;
    private final IStorageController SAC;
    private final FinalizedPromises finalizedPromises;

    public Engine(){
        UDPDriver driver = new UDPDriver(4055);
        this.network = new NetworkManager(driver);
        this.finalizedPromises = new FinalizedPromises();
        this.SAC = new Queue(this.finalizedPromises);

        Thread thread2 = new Thread(
                new StorageCycle(this.SAC)
        );
        thread2.start();
    }

    public void mainCycle(){
        try{
            NetworkDTO in = this.network.recive();
            System.out.println(in);
            Promise p1 = SAC.add(in.opName(), in.args());
            System.out.println("eng: " + p1);
        }
        catch (Exception e){

        }
    }
}
