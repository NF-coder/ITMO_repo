package commands;

import java.util.ArrayDeque;
import java.util.HashMap;

import commands.converters.Converters;
import commands.parsers.AdditionalParsers;
import commands.parsers.EnumsParser;
import exceptions.UnacceptableValue;
import objects.enums.Climate;
import objects.enums.Government;
import objects.enums.StandardOfLiving;
import commands.utils.AddUtils;
import objects.City;
import workers.Reciver;

public class Add extends BasicCommand{
    public Add(){
        super("add", "Adds new City to collection." +
                "\n\t Example: add -name [String] -area [double] -population [long] -metersAboveSeaLevel [float]"
        );
    }

    public final void execute(HashMap<String, String> args){
        Reciver reciver = new Reciver();
        ArrayDeque<City> allEntitys = reciver.getAllEntities();

        try {
            City city = new City(
                    AddUtils.findFreeId(allEntitys),
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
            reciver.addEntity(
                    city
            );
        }
        catch (UnacceptableValue err){
            System.out.println("Ошибка во время создания объекта: " + err.getMessage());
        }
    }
}
