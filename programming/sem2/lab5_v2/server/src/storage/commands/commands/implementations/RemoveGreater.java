package storage.commands.commands.implementations;

import org.json.JSONObject;
import storage.commands.commands.Command;
import storage.commands.components.sql.CheckOwner;
import storage.objects.City;
import storage.objects.Coordinates;
import storage.objects.Human;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class RemoveGreater extends Command {
    private final Function<City, Double> fn = (elem) -> elem.getStandardOfLiving().getCost() * 0.3 +
            elem.getArea()*0.03 +
            elem.getClimate().getCost()*0.2 +
            elem.getPopulation()*0.0003;
    private final Comparator<City> comp = (elem1, elem2) -> fn.apply(elem1).compareTo(fn.apply(elem2));

    public RemoveGreater() {
        super("remove_greater");
    }
    public JSONObject call() throws Exception{
        City newCity = new City(args);

        driver.getCollection().stream()
                .filter(elem -> comp.compare(elem, newCity) > 0)
                .filter(item -> CheckOwner.apply(item.getId(), item.getCreator()))
                .map(City::getId)
                .forEach(elem -> this.driver.removeById(elem));

        return null;
    }
}