package server.storage;

import server.storage.control.IStorageController;

public class StructureDaemon {
    IStorageController controller;

    public StructureDaemon(IStorageController controller){
        this.controller = controller;
    }

    public void mainCycle(){
        while (true) {
            if (this.controller.hasNext()){
                this.controller.get();
            }
        }
    }
}
