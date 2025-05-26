package commands.implementations;

import commands.BasicCommand;
import commands.implementations.parsers.AdditionalParsers;
import commands.implementations.parsers.EnumsParser;
import commands.objects.enums.Climate;
import commands.objects.enums.Government;
import commands.objects.enums.StandardOfLiving;
import commands.objects.validators.CityValidators;
import core.Engine;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class AddIfMax extends BasicCommand {
    public AddIfMax(Consumer<HashMap<String,String>> outHandler) {
        super("add_if_max", "Adds new City to collection." +
                "\n\t Example: add_if_max -name [String] -area [double] -population [long] -metersAboveSeaLevel [float]",
                outHandler
        );
    }

    @Override
    public void execute(HashMap<String, String> args, Engine engine) throws Exception {
            CityValidators.validateName(args.get("name"));
            CityValidators.validateArea(args.get("area"));
            CityValidators.validatePopulation(args.get("population"));
            CityValidators.validateMetersAboveSeaLevel(args.get("metersAboveSeaLevel"));

            HashMap<String, String> args1 = AdditionalParsers.parseCoordinates(args, engine.invoker);
            HashMap<String, String> args2 = AdditionalParsers.parseHuman(args1, engine.invoker);

            args2.put("climate", EnumsParser.parse(Climate.class, "тип климата", engine.invoker).toString());
            args2.put("government", EnumsParser.parse(Government.class, "тип правительства", engine.invoker).toString());
            args2.put("standardOfLiving", EnumsParser.parse(StandardOfLiving.class, "стандарт качества жизни", engine.invoker).toString());

            engine.networkManager.send(
                    new NetworkRequestDTO(
                            "add_if_max",
                            args
                    )
            );
            this.getOutHandler().accept(
                    engine.networkManager.receive().result()
            );
    }
}
