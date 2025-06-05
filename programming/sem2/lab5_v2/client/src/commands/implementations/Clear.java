package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import org.json.JSONObject;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class Clear extends BasicCommand {
    public Clear(Consumer<String> outHandler){
        super("clear", "Clears all information about collection.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "clear",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
