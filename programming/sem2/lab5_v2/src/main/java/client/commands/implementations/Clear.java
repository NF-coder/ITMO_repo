package client.commands.implementations;

import client.commands.BasicCommand;
import client.core.Engine;
import client.network.NetworkManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;
import java.util.HashMap;

public class Clear extends BasicCommand {
    public Clear(){
        super("clear", "Clears all information about collection.");
    }

    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "clear",
                        new HashMap<>()
                )
        );
        NetworkResponseDTO nmr = engine.networkManager.receive();
        System.out.println(nmr);
    }
}
