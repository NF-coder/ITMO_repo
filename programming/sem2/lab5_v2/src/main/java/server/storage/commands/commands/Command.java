package server.storage.commands.commands;

import server.storage.collection.drivers.IStructDriver;

import java.util.HashMap;
import java.util.concurrent.Callable;

public abstract class Command<T> implements Callable<T> {
    public String NAME;
    protected IStructDriver driver;
    protected HashMap<String,String> args;

    protected Command(String name) {
        this.NAME = name;
    }
    public void setData(HashMap<String, String> args,  IStructDriver driver) {
        this.args = args;
        this.driver = driver;
    }
    public String getName() {
        return this.NAME;
    }

    public abstract T call() throws Exception;
}