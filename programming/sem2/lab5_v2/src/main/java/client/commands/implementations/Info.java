package client.commands.implementations;

import client.commands.BasicCommand;
import client.network.NetworkManager;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.util.HashMap;

public class Info extends BasicCommand {
    public Info(){
        super("info", "Returns information about Collection.");
    }

    public final void execute(HashMap<String, String> args, NetworkManager networkManager) throws Exception {
        networkManager.send(
                new NetworkRequestDTO(
                        "info",
                        new HashMap<>()
                )
        );
        NetworkResponseDTO nmr = networkManager.receive();
        System.out.println(nmr);
    }
}
