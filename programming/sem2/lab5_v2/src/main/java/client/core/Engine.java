package client.core;

import java.util.HashMap;
import client.commands.BasicCommand;
import client.commands.implementations.*;
import client.network.NetworkManager;
import client.network.drivers.UDPDriver;

public final class Engine {
    UDPDriver driver = new UDPDriver(4059, 4056);
    NetworkManager networkManager = new NetworkManager(driver);

    private static final BasicCommand[] commands = {new Help(), new Add(), new Info(),
            new Clear(), new Exit(), new Show(), new Update(), new Execute(), new Save()};

    private final HashMap<String, BasicCommand> commandsHashMap = new HashMap<>();

    public Engine(){
        this.initCommandsHashMap();
    }

    private void initCommandsHashMap(){
        for (BasicCommand command: Engine.commands){
            this.commandsHashMap.put(command.getName(), command);
        }
    }

    public static BasicCommand[] getCommands(){
        return Engine.commands;
    }

    public void runCommand(String commandName, HashMap<String,String> args){
        BasicCommand command = this.commandsHashMap.get(commandName);

        if (command == null){
            System.out.println("Команда не найдена");
            return;
        }

        try {
            command.execute(
                    args,
                    this.networkManager
            );
        }
        catch (Exception err){
            System.out.println("Выполнение команды неожиданно прервалось со следующей ошибкой: "+err);
        }
    }
}
