package storage.commands.commands.implementations;

import org.json.JSONObject;
import storage.commands.commands.Command;
import storage.objects.City;

public class Add extends Command {
    public Add() {
        super("add");
    }

    public JSONObject call() throws Exception{
        this.driver.add(
                new City(args)
        );
        return null;
    }
}
