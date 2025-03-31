package storage;

import storage.promise.Promise;
import storage.promise.PromiseStatus;

import java.util.ArrayDeque;
import java.util.HashMap;

public class StructQueue {
    private final ArrayDeque<Promise> operations = new ArrayDeque<>();

    public Promise call(String operation, HashMap<String,String> args){
        Promise promise = new Promise(
                operation,
                PromiseStatus.CREATED,
                args,
                new HashMap<>()
        );
        this.operations.addLast(
                promise
        );
        return promise;
    }

    public int getQueueSize(){
        return operations.size();
    }

    public Promise getOperation(){
        return this.operations.pollFirst();
    }
}
