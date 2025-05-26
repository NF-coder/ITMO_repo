package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class Load extends BasicCommand {
    public Load(Consumer<HashMap<String,String>> outHandler){
        super("load", "loads collection from CSV file.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "load",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
