package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.City;

import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class FilterStartsWithName extends Command<ArrayDeque<City>> {
    public FilterStartsWithName() {
        super("filter_starts_with_name");
    }
    public ArrayDeque<City> call(){
        return  this.driver.getCollection().stream()
                .filter(elem -> elem.getName().indexOf(this.args.get("name_beginning")) == 0)
                .collect(Collectors.toCollection(ArrayDeque<City>::new));
    }
}
