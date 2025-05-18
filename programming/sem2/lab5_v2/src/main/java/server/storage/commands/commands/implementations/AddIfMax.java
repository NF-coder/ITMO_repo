package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;

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
    public String call() throws Exception{
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