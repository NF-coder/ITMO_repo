package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;
import server.storage.objects.enums.StandardOfLiving;

public class RemoveAllByStandardOfLiving extends Command {
    public RemoveAllByStandardOfLiving() {
        super(
                "remove_all_by_standard_of_living",
                new ArgsBuilderV2()
                        .putEnum("standard_of_living", StandardOfLiving.class)
        );
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
