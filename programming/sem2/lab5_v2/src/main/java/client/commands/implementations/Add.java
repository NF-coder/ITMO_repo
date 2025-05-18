package client.commands.implementations;

import java.util.HashMap;
import java.util.function.Consumer;

import client.commands.exceptions.UnacceptableValue;
import client.commands.objects.validators.CityValidators;
import client.commands.implementations.parsers.AdditionalParsers;
import client.commands.implementations.parsers.EnumsParser;
import client.commands.objects.enums.Climate;
import client.commands.objects.enums.Government;
import client.commands.objects.enums.StandardOfLiving;
import client.commands.BasicCommand;
import client.core.Engine;
import client.network.NetworkManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

public class Add extends BasicCommand {
    public Add(Consumer<HashMap<String,String>> outHandler) {
        super("add", "Adds new City to collection." +
                "\n\t Example: add -name [String] -area [double] -population [long] -metersAboveSeaLevel [float]",
                outHandler
        );
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception {
        try {
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
                            "add",
                            args2
                    )
            );
            this.getOutHandler().accept(
                    engine.networkManager.receive().result()
            );
        } catch (UnacceptableValue err) {
            System.out.println("Ошибка во время создания объекта: " + err.getMessage());
        }
    }
}
