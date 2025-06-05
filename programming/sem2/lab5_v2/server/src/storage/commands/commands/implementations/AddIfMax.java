package storage.commands.commands.implementations;

import org.json.JSONObject;
import storage.commands.commands.Command;
import storage.objects.City;
import storage.objects.Coordinates;
import storage.objects.Human;

import java.util.Comparator;
import java.util.function.Function;

public class AddIfMax extends Command {
    private final Function<City, Double> fn = (elem) -> elem.getStandardOfLiving().getCost() * 0.3 +
            elem.getArea()*0.03 +
            elem.getClimate().getCost()*0.2 +
            elem.getPopulation()*0.0003;
    public AddIfMax() {
        super("add_if_max");
    }
    public JSONObject call() throws Exception{
        Double value =  driver.getCollection().stream()
                .map(fn)
                .max(Comparator.comparing(Double::valueOf))
                .orElse(Double.MIN_VALUE);

        City newCity = new City(args);

        if(value <= fn.apply(newCity)) {
            this.driver.add(newCity);
        }
        return null;
    }
}