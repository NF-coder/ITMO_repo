package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;

public class Add extends Command {
    public Add() {
        super("add");
    }

    public String call() throws Exception{
        City newCity = new City();

        newCity.setName(args.get("name"));
        newCity.setArea(args.get("area"));
        newCity.setPopulation(args.get("population"));
        newCity.setMetersAboveSeaLevel(args.get("metersAboveSeaLevel"));
        newCity.setClimate(args.get("climate"));
        newCity.setGovernment(args.get("government"));
        newCity.setStandardOfLiving(args.get("standardOfLiving"));
        newCity.setCoordinates(
                new Coordinates(
                        args.get("x"),
                        args.get("y")
                )
        );
        newCity.setGovernor(
                new Human(
                         args.get("govName"),
                         args.get("age"),
                         args.get("height"),
                         args.get("birthday")
                )
        );
        this.driver.add(
                newCity
        );
        return null;
    }
}
