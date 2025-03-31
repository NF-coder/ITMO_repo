package storage;

import storage.promise.Promise;

import java.util.HashMap;

public class StructAccess {
    Struct struct;
    StructQueue queue;

    HashMap<>

    public StructAccess(Struct struct, StructQueue queue){
        this.struct = struct;
        this.queue = queue;
    }

    public void runTask(){
        Promise promise = queue.getOperation();
    }
}
