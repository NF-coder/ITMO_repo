package client.commands.implementations;

import client.commands.BasicCommand;
import client.network.NetworkManager;
import client.textWorkers.Invokers.FileInvoker;

import java.util.HashMap;

public class Execute extends BasicCommand {
    public Execute() {
        super("execute_script", "Takes commands from file." +
                "\n\t Example: execute_script -filename [String]");
    }

    public final void execute(HashMap<String, String> args, NetworkManager networkManager) {
        FileInvoker invoker = new FileInvoker();
        invoker.mainCycle();
    }
}