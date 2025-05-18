package client.commands.implementations;

import client.commands.BasicCommand;
import client.core.Engine;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class Save extends BasicCommand {
    public Save(Consumer<HashMap<String,String>> outHandler){
        super("save", "saves collection to CSV file.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "save",
                        new HashMap<>()
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}