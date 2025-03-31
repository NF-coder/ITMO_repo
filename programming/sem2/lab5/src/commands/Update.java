package commands;

import objects.converters.Converters;
import commands.utils.AddUtils;
import exceptions.ElementNotFound;
import exceptions.UnacceptableValue;
import objects.City;
import storage.Structure;

import java.util.HashMap;

public class Update extends BasicCommand{
    public Update(){
        super("update", "Updates City with specified id" +
                "\n\t Example: update -id [Long] -name [String] -area [double] -population [long] -metersAboveSeaLevel [float]"
        );
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();


        try {
            City city = new City(
                    Converters.StringToLong(args.get("id")),
                    args.get("name"),
                    AddUtils.generateLocalDateTime(),
                    args.get("area"),
                    args.get("population"),
                    args.get("metersAboveSeaLevel")
            );
            structure.updateEntityById(
                    Converters.StringToLong(args.get("id")), city
            );
        }
        catch (UnacceptableValue err){
            System.out.println("Ошибка во время создания новой версии объекта: " + err.getMessage());
        }
        catch (ElementNotFound err){
            System.out.println("Ошибка во время поиска исходного объекта: " + err.getMessage());
        }
    }
}
