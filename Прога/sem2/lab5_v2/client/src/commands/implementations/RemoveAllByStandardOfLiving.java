package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.function.Consumer;

public class RemoveAllByStandardOfLiving extends BasicCommand {
    public RemoveAllByStandardOfLiving(Consumer<String> outHandler){
        super("remove_all_by_standard_of_living", "Removes all cities with specified standard of life", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new shared.objects.NetworkRequestDTO(
                        "remove_all_by_standard_of_living",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
