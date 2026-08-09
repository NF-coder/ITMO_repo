package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.enums.StandardOfLiving;

public class RemoveAllByStandardOfLiving extends Command<Void> {
    public RemoveAllByStandardOfLiving() {
        super("remove_all_by_standard_of_living");
    }
    public Void call(){
        driver.getCollection().stream()
                .filter(item -> item.standardOfLiving.equals(
                        StandardOfLiving.valueOf(args.get("standard_of_living"))
                ))
                .forEach(
                        elem -> driver.removeById(elem.id)
                );
        return null;
    }
}
