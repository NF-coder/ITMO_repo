package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import org.json.JSONObject;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class Show extends BasicCommand {
    public Show(Consumer<JSONObject> outHandler){
        super("show", "Shows all entities from collection.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "show",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
