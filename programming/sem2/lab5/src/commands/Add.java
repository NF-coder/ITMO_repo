package commands;

import java.util.ArrayDeque;
import java.util.HashMap;

import exceptions.UnacceptableValue;
import commands.utils.AddUtils;
import objects.City;
import storage.Structure;

public class Add extends BasicCommand{
    public Add(){
        super("add", "Adds new City to collection." +
                "\n\t Example: add -name [String] -area [double] -population [long] -metersAboveSeaLevel [float]"
        );
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();
        ArrayDeque<City> allEntities = structure.getAllEntities();
        try {
            City city = new City(
                    AddUtils.findFreeId(allEntities),
                    args.get("name"),
                    AddUtils.generateLocalDateTime(),
                    args.get("area"),
                    args.get("population"),
                    args.get("metersAboveSeaLevel")
            );
            structure.addEntity(
                    city
            );
        }
        catch (UnacceptableValue err){
            System.out.println("Ошибка во время создания объекта: " + err.getMessage());
        }
    }
}
