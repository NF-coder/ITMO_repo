package client.commands.implementations;

import java.util.HashMap;

import client.commands.exceptions.UnacceptableValue;
import client.commands.objects.validators.CityValidators;
import client.commands.implementations.parsers.AdditionalParsers;
import client.commands.implementations.parsers.EnumsParser;
import client.commands.objects.enums.Climate;
import client.commands.objects.enums.Government;
import client.commands.objects.enums.StandardOfLiving;
import client.commands.BasicCommand;
import client.network.NetworkManager;
import shared.objects.NetworkRequestDTO;

public class Add extends BasicCommand {
    public Add(){
        super("add", "Adds new City to collection." +
                "\n\t Example: add -name [String] -area [double] -population [long] -metersAboveSeaLevel [float]"
        );
    }

    public final void execute(HashMap<String, String> args, NetworkManager networkManager) throws Exception {
        try {
            CityValidators.validateName(args.get("name"));
            CityValidators.validateArea(args.get("area"));
            CityValidators.validatePopulation(args.get("population"));
            CityValidators.validateMetersAboveSeaLevel(args.get("metersAboveSeaLevel"));

            HashMap<String, String> args1 = AdditionalParsers.parseCoordinates(args);
            HashMap<String, String> args2 = AdditionalParsers.parseHuman(args1);

            args2.put("climate", EnumsParser.parse(Climate.class, "тип климата").toString());
            args2.put("government", EnumsParser.parse(Government.class, "тип правительства").toString());
            args2.put("standardOfLiving", EnumsParser.parse(StandardOfLiving.class, "стандарт качества жизни").toString());

            networkManager.send(
                    new NetworkRequestDTO(
                            "add",
                            args2
                    )
            );
        }
        catch (UnacceptableValue err){
            System.out.println("Ошибка во время создания объекта: " + err.getMessage());
        }
    }
}
