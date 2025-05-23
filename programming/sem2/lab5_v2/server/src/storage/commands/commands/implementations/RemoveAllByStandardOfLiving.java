package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.enums.StandardOfLiving;

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
                .forEach(
                        elem -> driver.removeById(elem.getId())
                );
        return null;
    }
}
