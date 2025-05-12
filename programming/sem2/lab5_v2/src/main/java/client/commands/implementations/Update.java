package client.commands.implementations;

import client.commands.exceptions.ElementNotFound;
import client.commands.exceptions.UnacceptableValue;
import client.commands.implementations.parsers.AdditionalParsers;
import client.commands.objects.validators.CityValidators;
import client.core.Engine;
import client.network.NetworkManager;
import client.commands.implementations.parsers.EnumsParser;
import client.commands.objects.enums.Climate;
import client.commands.objects.enums.Government;
import client.commands.objects.enums.StandardOfLiving;
import client.commands.BasicCommand;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;

public class Update extends BasicCommand {
    public Update(){
        super("update", "Updates City with specified id" +
                "\n\t Example: update -id [Long] -name [String] -area [double] -population [long] -metersAboveSeaLevel [float]"
        );
    }

    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        try {
            CityValidators.validateName(args.get("name"));
            CityValidators.validateArea(args.get("area"));
            CityValidators.validatePopulation(args.get("population"));
            CityValidators.validateMetersAboveSeaLevel(args.get("metersAboveSeaLevel"));

            HashMap<String, String> args1 = AdditionalParsers.parseCoordinates(args, engine.invoker);
            HashMap<String, String> args2 = AdditionalParsers.parseHuman(args1, engine.invoker);

            args2.put("climate", EnumsParser.parse(Climate.class, "тип климата", engine.invoker).toString());
            args2.put("government", EnumsParser.parse(Government.class, "тип правительства", engine.invoker).toString());
            args2.put("governor", EnumsParser.parse(StandardOfLiving.class, "стандарт качества жизни", engine.invoker).toString());

            engine.networkManager.send(
                    new NetworkRequestDTO(
                            "update",
                            args2
                    )
            );
            engine.networkManager.receive();
        }
        catch (UnacceptableValue err){
            System.out.println("Ошибка во время создания новой версии объекта: " + err.getMessage());
        }
    }
}
