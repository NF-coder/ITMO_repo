package server.commands;

import server.commands.commands.Add;
import server.commands.commands.ICommand;
import server.commands.commands.Update;
import server.storage.drivers.IStructDriver;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;
import server.storage.objects.enums.StandardOfLiving;

import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CommandsManager {
    private final IStructDriver driver;
    HashMap<String, ICommand> opTable = new HashMap<>();
    private final ICommand[] opArr = {new Add(), new Update()};

    public CommandsManager(IStructDriver driver){
        this.driver = driver;
        this.initOpTable();
    }

    private void initOpTable(){
        for (ICommand op: this.opArr){
            this.opTable.put(op.getName(), op);
        }
    }

    public void op1(HashMap<String, String> args) {
        System.out.println("op1 call");
    }
    public void add(HashMap<String, String> city){
        try{
            new Add().run(driver, city);
        }
        catch (Exception e){ }
    }
    public void update(HashMap<String,String> newObj){
        try{
            new Update().run(driver, newObj);
        }
        catch (Exception e){ }
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