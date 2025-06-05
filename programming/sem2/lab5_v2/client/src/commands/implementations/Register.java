package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.function.Consumer;

public class Register extends BasicCommand {
    public Register(Consumer<String> outHandler) {
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
