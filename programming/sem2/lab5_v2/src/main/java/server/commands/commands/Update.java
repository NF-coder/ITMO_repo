package server.commands.commands;

import server.storage.drivers.IStructDriver;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;
import server.storage.objects.exceptions.ElementNotFound;
import server.storage.objects.exceptions.UnacceptableValue;

import java.util.HashMap;

public class Update implements ICommand<HashMap<String,String>, Void> {
    private final String NAME = "add";

    public Void run(IStructDriver driver, HashMap<String,String> args) throws UnacceptableValue, ElementNotFound {
        City obj = driver.getById(
                Long.parseLong(
                        args.get("id")
                )
        );
        City newCity = new City(
                obj.id,
                args.get("name"),
                obj.creationDate,
                args.get("area"),
                args.get("population"),
                args.get("matersAboveSeaLevel"),
                args.get("climate"),
                args.get("government"),
                args.get("standardOfLiving"),
                new Coordinates(
                        args.get("x"),
                        args.get("y")
                ),
                new Human(
                        args.get("name"),
                        args.get("age"),
                        args.get("height"),
                        args.get("birthday")
                )
        );
        driver.add(
                newCity
        );
        return null;
    }

    public String getName() {
        return this.NAME;
    }
}
