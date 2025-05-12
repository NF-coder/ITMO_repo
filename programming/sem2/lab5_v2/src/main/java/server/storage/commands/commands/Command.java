package server.storage.commands.commands;

import org.json.JSONObject;
import server.storage.collection.drivers.IStructDriver;
import server.storage.commands.commands.argsBuilder.ArgsBuilder;

import java.util.HashMap;

import java.util.function.Supplier;

public abstract class Command implements Supplier<JSONObject> {
    public String NAME;
    protected IStructDriver driver;
    protected HashMap<String,String> args;
    public ArgsBuilder reqArgs;

    protected Command(String name) {
        this.NAME = name;
        this.reqArgs = new ArgsBuilder();
    }
    protected Command(String name, ArgsBuilder argsBuilder) {
        this.NAME = name;
        this.reqArgs = argsBuilder;
    }
    public void setData(HashMap<String, String> args,  IStructDriver driver) {
        this.args = args;
        this.driver = driver;
    }
    public String getName() {
        return this.NAME;
    }
    public JSONObject getArgs(){
        return this.reqArgs.get();
    }

    public abstract String call() throws Exception;

    public JSONObject get(){
        try {
            String result = this.call();
            JSONObject jo = new JSONObject();

            jo.put("status", String.valueOf(Status.OK));
            if (result != null) jo.put("result", result);
            else jo.put("result", "successfully completed");

            return jo;
        }
        catch (Exception e) {
            JSONObject h = new JSONObject();

            h.put("status", String.valueOf(Status.ERROR));
            h.put("description", e.getMessage());
            return h;
        }
    }
}