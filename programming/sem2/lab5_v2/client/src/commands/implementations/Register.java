package commands.implementations;

import commands.BasicCommand;
import commands.exceptions.UnacceptableValue;
import commands.implementations.parsers.AdditionalParsers;
import commands.implementations.parsers.EnumsParser;
import commands.objects.enums.Climate;
import commands.objects.enums.Government;
import commands.objects.enums.StandardOfLiving;
import commands.objects.validators.CityValidators;
import core.Engine;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.function.Consumer;

public class Register extends BasicCommand {
    public Register(Consumer<JSONObject> outHandler) {
        super("register", "Registers new user",
                outHandler
        );
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception {
        engine.networkManager.send(
                new shared.objects.NetworkRequestDTO(
                        "register",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
