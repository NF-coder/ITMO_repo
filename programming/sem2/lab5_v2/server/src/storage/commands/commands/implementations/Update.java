package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;
import server.storage.objects.exceptions.ElementNotFound;
import server.storage.objects.exceptions.UnacceptableValue;

import java.util.HashMap;

public class Update extends Command {
    public Update(){
        super("update");
    }
    public String call() throws UnacceptableValue, ElementNotFound {
        City obj = this.driver.getById(
                Long.parseLong(
                        this.args.get("id")
                )
        );
        City newCity = new City(args);
        newCity.setId(obj.getId());
        newCity.setCreationDate(obj.getCreationDate());

        this.driver.add(newCity);
        return null;
    }
}
