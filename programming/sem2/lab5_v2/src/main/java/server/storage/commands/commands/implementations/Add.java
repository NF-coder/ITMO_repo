package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilder;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;
import server.storage.objects.enums.Climate;
import server.storage.objects.enums.Government;
import server.storage.objects.enums.StandardOfLiving;

public class Add extends Command {
    private final ArgsBuilder futureArgs = new ArgsBuilder()
                        .addString("name")
                        .addInteger("area", 0L, null)
                        .addInteger("population", 0L, null)
                        .addInteger("metersAboveSeaLevel")
                        .addEnum("climate", Climate.class)
                        .addEnum("government", Government.class)
                        .addEnum("standardOfLiving", StandardOfLiving.class)
                        .addReal("x")
                        .addReal("y")
                        .addString("govName")
                        .addInteger("age")
                        .addInteger("height")
                        .addDate("birthday");

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
