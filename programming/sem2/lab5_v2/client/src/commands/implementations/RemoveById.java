package commands.implementations;


import commands.BasicCommand;
import core.Engine;

import java.util.HashMap;
import java.util.function.Consumer;

public class RemoveById extends BasicCommand {
    public RemoveById(Consumer<HashMap<String,String>> outHandler){
        super("remove_by_id", "Clears all information about collection.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new shared.objects.NetworkRequestDTO(
                        "remove_by_id",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
