package server.commands.commands;

import server.storage.drivers.IStructDriver;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;
import server.storage.objects.exceptions.UnacceptableValue;

import java.util.HashMap;

public class Add implements ICommand<HashMap<String,String>, Void>{
    private final String NAME = "add";

    public Void run(IStructDriver driver, HashMap<String,String> args) throws UnacceptableValue {
        City newCity = new City(
                driver.generateId(),
                args.get("name"),
                driver.generateDateTime(),
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
