package commands;

import commands.converters.Converters;
import commands.parsers.AdditionalParsers;
import commands.parsers.EnumsParser;
import commands.utils.AddUtils;
import exceptions.ElementNotFound;
import exceptions.UnacceptableValue;
import objects.City;
import objects.enums.Climate;
import objects.enums.Government;
import objects.enums.StandardOfLiving;
import workers.Reciver;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Update extends BasicCommand{
    public Update(){
        super("update", "Updates City with specified id" +
                "\n\t Example: update -id [Long] -name [String] -area [double] -population [long] -metersAboveSeaLevel [float]"
        );
    }

    public final void execute(HashMap<String, String> args){
        Reciver reciver = new Reciver();


        try {
            City city = new City(
                    Converters.StringToLong(args.get("id")),
                    args.get("name"),
                    AdditionalParsers.parseCoordinates(),
                    AddUtils.generateLocalDateTime(),
                    Converters.StringToPrimitiveDouble(args.get("area")),
                    Converters.StringToPrimitiveLong(args.get("population")),
                    Converters.StringToPrimitiveFloat(args.get("metersAboveSeaLevel")),
                    EnumsParser.parse(Climate.class, "тип климата"),
                    EnumsParser.parse(Government.class, "тип правительства"),
                    EnumsParser.parse(StandardOfLiving.class, "стандарт качества жизни"),
                    AdditionalParsers.parseHuman()
            );
            reciver.updateEntityById(
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
