package server.storage.control;

import server.core.promise.FinalizedPromises;
import server.core.promise.Promise;
import java.util.ArrayDeque;
import java.util.HashMap;

public class StorageQueue implements IStorageController{
    private final ArrayDeque<Promise> operations = new ArrayDeque<>();
    private final FinalizedPromises finalizedPromises;

    public StorageQueue(FinalizedPromises finalizedPromises){
        this.finalizedPromises = finalizedPromises;
    }

    public Promise add(String operationName, HashMap<String,String> args){
        Promise promise = new Promise(
                operationName,
                args,
                this.finalizedPromises
        );
        this.operations.addLast(
                promise
        );
        System.out.println(this.operations.size());
        return promise;
    }

    public Promise get(){
        Promise pr = this.operations.pollFirst();
        System.out.println("q-get: " + pr);
        return pr;
    }

    public boolean hasNext(){
        try{
            Thread.sleep(1000);
        }catch (Exception e) {}
        //System.out.println("NXT: " + operations.size());
        return !this.operations.isEmpty();
    }
}
