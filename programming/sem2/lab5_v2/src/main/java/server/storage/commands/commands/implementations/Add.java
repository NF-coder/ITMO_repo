package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilder;
import server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.implementations.PABv2;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;
import server.storage.objects.enums.Climate;
import server.storage.objects.enums.Government;
import server.storage.objects.enums.StandardOfLiving;

import java.util.HashMap;

public class Add extends Command {
    private final ArgsBuilder<HashMap<String,String>> futureArgs = new ArgsBuilder<>(new PABv2())
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
        System.out.println(futureArgs.get());
    }

    public String call() throws Exception{
        this.driver.add(
                new City(args)
        );
        return null;
    }
}
