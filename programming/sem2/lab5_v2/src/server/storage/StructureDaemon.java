package server.storage;

import server.core.promise.Promise;
import server.storage.control.IStorageController;

import java.lang.reflect.Method;
import java.util.HashMap;

public class StructureDaemon {
    IStorageController controller;
    HashMap<String, Method> opTable = new HashMap<>();
    StructureManager manager;

    public StructureDaemon(IStorageController controller, StructureManager manager){
        this.controller = controller;
        this.manager = manager;
        this.initOpTable();
    }

    private void initOpTable(){
        for(Method m : this.manager.getClass().getDeclaredMethods()){
            this.opTable.put(m.getName(), m);
        }
    }

    public void mainCycle(){
        System.out.println("Struct Daemon main cycle started");
        while (true) {
            if (this.controller.hasNext()){
                System.out.println("main cycle Struct Daemon op");
                Promise op = this.controller.get();
                try{
                    this.opTable.get(
                            op.getOperationName()
                    ).invoke(
                            this.manager,
                            op.getArguments()
                    );
                }
                catch (Exception err){
                    op.setError(err.toString());
                }
                System.out.println(op);
            }
        }
    }
}
