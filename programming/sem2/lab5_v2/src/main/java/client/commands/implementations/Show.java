package client.commands.implementations;

import client.commands.BasicCommand;
import client.network.NetworkManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.util.HashMap;

public class Show extends BasicCommand {
    public Show(){
        super("show", "Shows all entities from collection.");
    }

    public final void execute(HashMap<String, String> args, NetworkManager networkManager) throws Exception{
        networkManager.send(
                new NetworkRequestDTO(
                        "show",
                        new HashMap<>()
                )
        );
        NetworkResponseDTO nmr = networkManager.receive();
        System.out.println(nmr);
    }
}
