package client.commands.implementations;

import client.commands.BasicCommand;
import client.core.Engine;
import client.network.NetworkManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;
import java.util.HashMap;
import java.util.function.Consumer;

public class Clear extends BasicCommand {
    public Clear(Consumer<HashMap<String,String>> outHandler){
        super("clear", "Clears all information about collection.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "clear",
                        new HashMap<>()
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
