package client.core;

import java.util.HashMap;

import client.commands.BasicCommand;
import client.commands.implementations.*;
import client.network.NetworkManager;
import client.network.drivers.UDPDriver;
import client.textWorkers.Invoker;
import client.textWorkers.Invokers.CLInvoker;
import client.textWorkers.Invokers.IInvoker;

public final class Engine {
    UDPDriver driver = new UDPDriver(4059, 4056);
    public NetworkManager networkManager = new NetworkManager(driver);

    private static final BasicCommand[] commands = {new Help(), new Add(), new Info(),
            new Clear(), new Exit(), new Show(), new Update(), new Execute(), new Save()};

    private final HashMap<String, BasicCommand> commandsHashMap = new HashMap<>();

    public IInvoker invoker = new CLInvoker();

    public Engine() {
        this.initCommandsHashMap();
    }

    public void start(){invoker.mainCycle(this);}
    public void setInvoker(IInvoker invoker) {
        this.invoker = invoker;
        this.start();
    }

    private void initCommandsHashMap() {
        for (BasicCommand command : Engine.commands) {
            this.commandsHashMap.put(command.getName(), command);
        }
    }

    public static BasicCommand[] getCommands() {
        return Engine.commands;
    }

    public void runCommand(String commandName, HashMap<String, String> args) {
        BasicCommand command = this.commandsHashMap.get(commandName);

        if (command == null) {
            System.out.println("Команда не найдена");
            return;
        }

        try {
            command.execute(
                    args,
                    this
            );
        } catch (Exception err) {
            System.out.println("Выполнение команды неожиданно прервалось со следующей ошибкой: " + err);
        }
    }
}
