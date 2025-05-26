package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.objects.City;

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
