package core;

import commands.*;
import textWorkers.invokers.IInvoker;

import java.util.HashMap;

public final class Engine {
    private final static BasicCommand[] commands = {new Help(), new Add(), new Info(),
            new Clear(), new Exit(), new Show(), new Update(), new Execute(), new RemoveById(),
            new RemoveFirst(), new RemoveAllByStandardOfLiving(), new AverageOfMetersAboveSeaLevel(),
            new FilterStartsWithName(), new Save()
    };
    private final HashMap<String, BasicCommand> commandsHashMap = new HashMap<>();
    private static IInvoker activeInvoker;

    public Engine(){
        this.initCommandsHashMap();
    }
    public static void setActiveInvoker(IInvoker invoker){
        Engine.activeInvoker    = invoker;
    }
    public static IInvoker getActiveInvoker(){
        return Engine.activeInvoker;
    }
    public void start(){
        Engine.activeInvoker.mainCycle(this);
    }

    /**
     * Процедура, создающая хэш-таблицу с командами.
     * Должна быть обязательно вызвана при инициализации класса Engine
     */
    private void initCommandsHashMap(){
        for (BasicCommand command: Engine.commands){
            this.commandsHashMap.put(command.getName(), command);
        }
    }

    /**
     * Метод, дающий возможность узнать список
     * обрабатываемых команд
     * @return BasicCommand[] Список зарегистрированных команд
     * @see BasicCommand
     */
    public static BasicCommand[] getCommands(){
        return Engine.commands;
    }

    /**
     * Метод, используемый для запуска команд.
     * @param commandName Имя команды
     * @param args Хэш-таблица с аргументами команды и их значениями
     */
    public void runCommand(String commandName, HashMap<String,String> args){
        BasicCommand command = this.commandsHashMap.get(commandName);

        if (command == null){
            System.out.println("Команда не найдена");
            return;
        }

        try {
            command.execute(args);
        }
        catch (Exception err){
            System.out.println("Выполнение команды неожиданно прервалось со следующей ошибкой: "+err);
        }
    }
}
