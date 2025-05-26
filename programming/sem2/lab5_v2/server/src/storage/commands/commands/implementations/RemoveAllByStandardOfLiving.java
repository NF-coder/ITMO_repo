package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.commands.components.sql.CheckOwner;
import storage.commands.components.sql.operations.DTOs.CityIdAndCreatorDTO;
import storage.objects.enums.StandardOfLiving;

import java.util.HashMap;

public class RemoveAllByStandardOfLiving extends Command {
    public RemoveAllByStandardOfLiving() {
        super("remove_all_by_standard_of_living");
    }
    public String call(){
        driver.getCollection().stream()
                .filter(item -> item.getStandardOfLiving().equals(
                        StandardOfLiving.valueOf(args.get("standard_of_living"))
                ))
                .filter(item -> CheckOwner.apply(item.getId(), item.getCreator()))
                .forEach(
                        elem -> driver.removeById(elem.getId())
                );
        return null;
    }
}
