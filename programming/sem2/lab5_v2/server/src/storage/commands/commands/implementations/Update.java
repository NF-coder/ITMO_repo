package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.commands.components.sql.CheckOwner;
import storage.objects.City;
import storage.objects.exceptions.ElementNotFound;
import storage.objects.exceptions.UnacceptableValue;

public class Update extends Command {
    public Update(){
        super("update");
    }
    public String call() throws UnacceptableValue, ElementNotFound {
        if (!CheckOwner.apply(this.args.get("id"), this.args.get("login"))){
            throw new UnacceptableValue("You're not owner");
        }

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
