package server.storage;

import server.storage.drivers.IStructDriver;
import server.storage.objects.City;
import server.storage.objects.enums.StandardOfLiving;

import java.util.HashMap;

public class StructureManager {
    private final IStructDriver driver;

    public StructureManager(IStructDriver driver){
        this.driver = driver;
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
                    city.get("standardOfLiving")
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
                    newObj.get("standardOfLiving")
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
    public void remove_all_by_standard_of_living(String standard){
        this.driver.removeByStandardOfLiving(standard);
    }
    public float average_of_meters_above_sea_level(){
        return this.driver.averageOfMetersAboveSeaLevel();
    }
    public filter_starts_with_name(){
        return;
    }
}