package client.commands.implementations;

import client.commands.BasicCommand;
import client.network.NetworkManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;
import java.util.HashMap;

public class Clear extends BasicCommand {
    public Clear(){
        super("clear", "Clears all information about collection.");
    }

    public final void execute(HashMap<String, String> args, NetworkManager networkManager) throws Exception{
        networkManager.send(
                new NetworkRequestDTO(
                        "clear",
                        new HashMap<>()
                )
        );
        NetworkResponseDTO nmr = networkManager.receive();
        System.out.println(nmr);
    }
}
