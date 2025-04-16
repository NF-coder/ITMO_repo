package server.storage.control;

import server.core.promise.Promise;

import java.util.HashMap;

public interface IStorageController {
    public Promise add(String operationName, HashMap<String,String> args);
    public Promise get();
    public boolean hasNext();
}
