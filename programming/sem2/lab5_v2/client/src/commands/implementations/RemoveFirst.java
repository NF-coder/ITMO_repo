package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.function.Consumer;

public class RemoveFirst extends BasicCommand {
    public RemoveFirst(Consumer<JSONObject> outHandler){
        super("remove_first", "Removes first element from collection.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new shared.objects.NetworkRequestDTO(
                        "remove_first",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
