package client.commands.implementations;

import client.commands.BasicCommand;
import client.network.NetworkManager;

import java.util.HashMap;

public class Exit extends BasicCommand {
    public Exit(){
        super("exit", "Finishes CLI without saving collection to file");
    }

    public final void execute(HashMap<String, String> args, NetworkManager networkManager) {
        System.exit(0);
    }
}
