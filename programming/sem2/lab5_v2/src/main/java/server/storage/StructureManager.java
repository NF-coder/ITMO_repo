package server.storage;

import server.storage.drivers.IStructDriver;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;
import server.storage.objects.enums.StandardOfLiving;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.stream.Collectors;

public class StructureManager {
    private final IStructDriver driver;

    public StructureManager(IStructDriver driver){
        this.driver = driver;
    }

    public void op1(HashMap<String, String> args) {
        System.out.println("op1 call");
    }
    public void add(HashMap<String, String> city){
        try{
            City newCity = new City(
                    this.driver.generateId(),
                    city.get("name"),
                    this.driver.generateDateTime(),
                    city.get("area"),
                    city.get("population"),
                    city.get("matersAboveSeaLevel"),
                    city.get("climate"),
                    city.get("government"),
                    city.get("standardOfLiving"),
                    new Coordinates(
                            city.get("x"),
                            city.get("y")
                    ),
                    new Human(
                            city.get("name"),
                            city.get("age"),
                            city.get("height"),
                            city.get("birthday")
                    )
            );
            this.driver.add(
                    newCity
            );
        }
        catch (Exception e){

        }
    }
    public void update(Long id, HashMap<String,String> newObj){
        try{
            City obj = this.driver.getById(id);
            City newCity = new City(
                    obj.id,
                    newObj.get("name"),
                    obj.creationDate,
                    newObj.get("area"),
                    newObj.get("population"),
                    newObj.get("matersAboveSeaLevel"),
                    newObj.get("climate"),
                    newObj.get("government"),
                    newObj.get("standardOfLiving"),
                    new Coordinates(
                            newObj.get("x"),
                            newObj.get("y")
                    ),
                    new Human(
                            newObj.get("name"),
                            newObj.get("age"),
                            newObj.get("height"),
                            newObj.get("birthday")
                    )
            );
            this.driver.add(
                    newCity
            );
        }
        catch (Exception e){

        }
    }
    public void remove_by_id(Long id){
        this.driver.removeById(id);
    }
    public void clear(){
        this.driver.clearCollection();
    }
    public void remove_first(){
        this.driver.removeFirst();
    }
    public ArrayDeque<City> filter_starts_with_name(String nameBeginning){
        return  this.driver.getCollection().stream()
                .filter(elem -> elem.name.indexOf(nameBeginning) == 0)
                .collect(Collectors.toCollection(ArrayDeque<City>::new));
    }
    public void remove_all_by_standard_of_living(String standardOfLiving) {
        this.driver.getCollection().stream()
                .filter(item -> item.standardOfLiving.equals(
                        StandardOfLiving.valueOf(standardOfLiving)
                ))
                .forEach(
                        elem -> this.driver.removeById(elem.id)
                );
    }
    public float average_of_meters_above_sea_level(){
        return (float) this.driver.getCollection().stream()
                .mapToDouble(elem -> elem.metersAboveSeaLevel)
                .average()
                .orElse(Double.NaN);
    }
}