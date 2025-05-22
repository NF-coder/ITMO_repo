package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;
import server.storage.objects.City;
import server.storage.objects.validators.BuildSupplier;

public class Add extends Command {
    public Add() {
        super(
                "add",
                BuildSupplier.CityBuild(new ArgsBuilderV2())
        );
    }

    public String call() throws Exception{
        this.driver.add(
                new City(args)
        );
        return null;
    }
}
