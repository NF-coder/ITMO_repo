package server.storage.control;

import server.core.promise.Promise;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Queue implements IStorageController{
    private final ArrayDeque<Promise> operations = new ArrayDeque<>();

    public Promise add(String operationName, HashMap<String,String> args){
        Promise promise = new Promise(
                operationName,
                args
        );
        this.operations.addLast(
                promise
        );
        return promise;
    }

    public Promise get(){
        return this.operations.pollFirst();
    }

    public boolean hasNext(){
        return operations.isEmpty();
    }
}
