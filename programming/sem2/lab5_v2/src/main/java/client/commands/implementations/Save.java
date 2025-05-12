package client.commands.implementations;

import client.commands.BasicCommand;
import client.core.Engine;
import client.network.NetworkManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.util.HashMap;

public class Save extends BasicCommand {
    public Save(){
        super("save", "saves collection to CSV file.");
    }

    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "save",
                        new HashMap<>()
                )
        );
        NetworkResponseDTO nmr = engine.networkManager.receive();
        System.out.println(nmr);
    }
}