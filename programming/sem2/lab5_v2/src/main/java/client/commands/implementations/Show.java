package client.commands.implementations;

import client.commands.BasicCommand;
import client.core.Engine;
import client.network.NetworkManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.util.Arrays;
import java.util.HashMap;

public class Show extends BasicCommand {
    public Show(){
        super("show", "Shows all entities from collection.");
    }

    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "show",
                        new HashMap<>()
                )
        );
        System.out.println(engine.networkManager.receive());
    }
}
