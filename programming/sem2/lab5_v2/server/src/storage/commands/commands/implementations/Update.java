package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.objects.City;
import storage.objects.Coordinates;
import storage.objects.Human;
import storage.objects.exceptions.ElementNotFound;
import storage.objects.exceptions.UnacceptableValue;

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
