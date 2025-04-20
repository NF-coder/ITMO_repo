package server.storage;

import server.storage.control.IStorageController;
import server.storage.drivers.DequeDriver;

public class StorageCycle implements Runnable {
    private final StructureDaemon sd;

    public StorageCycle(IStorageController queue){
        this.sd = new StructureDaemon(queue, new StructureManager(new DequeDriver()));
        System.out.println("controller setted");
    }
    public void run(){
        System.out.println("storage cycle started");
        this.sd.mainCycle();
    }
}
