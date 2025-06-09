package commands.implementations;

import commands.exceptions.UnacceptableValue;
import commands.implementations.parsers.AdditionalParsers;
import commands.objects.validators.CityValidators;
import core.Engine;
import commands.implementations.parsers.EnumsParser;
import commands.objects.enums.Climate;
import commands.objects.enums.Government;
import commands.objects.enums.StandardOfLiving;
import commands.BasicCommand;
import org.json.JSONObject;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class Update extends BasicCommand {
    public Update(Consumer<String> outHandler){
        super("update", "Updates City with specified id" +
                "\n\t Example: update -id [Long] -name [String] -area [double] -population [long] -metersAboveSeaLevel [float]",
                outHandler
        );
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        /*CityValidators.validateName(args.get("name"));
        CityValidators.validateArea(args.get("area"));
        CityValidators.validatePopulation(args.get("population"));
        CityValidators.validateMetersAboveSeaLevel(args.get("metersAboveSeaLevel"));

        HashMap<String, String> args1 = AdditionalParsers.parseCoordinates(args, engine.invoker);
        HashMap<String, String> args2 = AdditionalParsers.parseHuman(args1, engine.invoker);

        args2.put("climate", EnumsParser.parse(Climate.class, "тип климата", engine.invoker).toString());
        args2.put("government", EnumsParser.parse(Government.class, "тип правительства", engine.invoker).toString());
        args2.put("governor", EnumsParser.parse(StandardOfLiving.class, "стандарт качества жизни", engine.invoker).toString());*/

        engine.networkManager.send(
                new NetworkRequestDTO(
                        "update",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
