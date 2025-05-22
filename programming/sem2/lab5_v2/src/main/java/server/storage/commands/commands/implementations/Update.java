package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;
import server.storage.objects.City;
import server.storage.objects.exceptions.ElementNotFound;
import server.storage.objects.exceptions.UnacceptableValue;
import server.storage.objects.validators.BuildSupplier;

public class Update extends Command {
    public Update(){
        super(
                "update",
                BuildSupplier.CityBuild(new ArgsBuilderV2())
                        .putInteger("id", 0L, null)
        );
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
