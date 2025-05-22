package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;
import server.storage.objects.validators.BuildSupplier;

import java.util.stream.Collectors;

public class FilterStartsWithName extends Command {
    public FilterStartsWithName() {
        super(
                "filter_starts_with_name",
                BuildSupplier.CityBuild(new ArgsBuilderV2())

        );
    }
    public String call(){
        return this.driver.getCollection().stream()
                .filter(elem -> elem.getName().indexOf(this.args.get("name_beginning")) == 0)
                .map(Object::toString)
                .collect(Collectors.joining(",\n"));
    }
}
