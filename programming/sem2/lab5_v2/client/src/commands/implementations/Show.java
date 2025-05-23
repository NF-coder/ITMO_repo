package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class Show extends BasicCommand {
    public Show(Consumer<HashMap<String,String>> outHandler){
        super("show", "Shows all entities from collection.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "show",
                        new HashMap<>()
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
