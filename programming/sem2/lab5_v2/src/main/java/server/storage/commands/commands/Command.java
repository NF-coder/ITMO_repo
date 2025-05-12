package server.storage.commands.commands;

import server.storage.collection.drivers.IStructDriver;
import server.storage.commands.commands.reqArgs.ArgsBuilder;

import java.util.HashMap;

import java.util.function.Supplier;

public abstract class Command implements Supplier<HashMap<String,String>> {
    public String NAME;
    protected IStructDriver driver;
    protected HashMap<String,String> args;
    //public ArgsBuilder reqArgs;

    protected Command(String name/*, ArgsBuilder argsBuilder*/) {
        this.NAME = name;
        //this.reqArgs = argsBuilder;
    }
    public void setData(HashMap<String, String> args,  IStructDriver driver) {
        this.args = args;
        this.driver = driver;
    }
    public String getName() {
        return this.NAME;
    }

    public abstract String call() throws Exception;

    public HashMap<String,String> get(){
        try {
            String result = this.call();
            HashMap<String, String> h = new HashMap<>();

            h.put("status", String.valueOf(Status.OK));
            if (result != null){
                h.put("result", result);
            }
            else {
                h.put("result", "successfully completed");
            }

            return h;
        }
        catch (Exception e) {
            HashMap<String,String> h = new HashMap<>();

            h.put("status", String.valueOf(Status.ERROR));
            h.put("description", e.getMessage());
            return h;
        }
    }
}