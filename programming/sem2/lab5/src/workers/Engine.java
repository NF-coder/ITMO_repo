package workers;

import commands.*;

import java.util.HashMap;

public final class Engine {
    private static BasicCommand[] commands = {new Help(), new Add(), new Info(),
            new Clear(), new Exit(), new Show(), new Update(), new Execute()};
    private HashMap<String, BasicCommand> commandsHashMap = new HashMap<>();

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
            command.execute(args);
        }
        catch (Throwable err){
            System.out.println("Выполнение команды неожиданно прервалось со следующей ошибкой: "+err);
        }
    }
}
