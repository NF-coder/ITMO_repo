package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class Info extends BasicCommand {
    public Info(Consumer<HashMap<String,String>> outHandler){
        super("info", "Returns information about Collection.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception {
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "info",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
