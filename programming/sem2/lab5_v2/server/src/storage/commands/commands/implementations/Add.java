package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.City;

public class Add extends Command {
    public Add() {
        super("add");
    }

    public String call() throws Exception{
        this.driver.add(
                new City(args)
        );
        return null;
    }
}
