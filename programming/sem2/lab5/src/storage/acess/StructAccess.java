package storage.acess;

import core.promise.Promise;
import storage.Structure;

import java.lang.reflect.Method;
import java.util.HashMap;

public class StructAccess {
    Structure struct;
    StructQueue queue;
    private final HashMap<String, Method> opTable = new HashMap<>();

    public StructAccess(Structure struct, StructQueue queue){
        this.struct = struct;
        this.queue = queue;
        initOpTable();
    }
    private void initOpTable(){
        for(Method m : this.struct.getClass().getDeclaredMethods()){
            this.opTable.put(m.getName(), m);
        }
    }

    public boolean hasAnyUnhandledTasks(){
        return this.queue.getQueueSize() == 0;
    }
    public void runTask(){
        Promise promise = queue.get();
        HashMap<String,String> args = promise.getArguments();

        try{
            this.opTable.get(
                    promise.getOperationName()
            ).invoke(
                    this.struct,
                    args
            );
        }
        catch (Exception err){
            promise.setError(err.toString());
        }
    }

}
