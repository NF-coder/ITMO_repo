package client.core;

import java.util.HashMap;
import java.util.function.Consumer;

import client.commands.BasicCommand;
import client.commands.implementations.*;
import client.commands.implementations.components.output.CommandOutput;
import client.network.NetworkManager;
import client.network.drivers.INetworkDriver;
import client.network.drivers.implementations.TCPDriver;
import client.textWorkers.Invokers.CLInvoker;
import client.textWorkers.Invokers.IInvoker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Engine {
    INetworkDriver driver = new TCPDriver(4059, 4056);

    public NetworkManager networkManager = new NetworkManager(driver);

    private final Logger logger = LogManager.getLogger();

    public Consumer<HashMap<String,String>> printer = CommandOutput::logger;

    private final BasicCommand[] commands = {
            new Help(printer), new Add(printer), new Info(printer),
            new Clear(printer), new Exit(), new Show(printer),
            new Update(printer), new Execute(printer), new Save(printer),
            new AvgOfMetersAboveSea(printer), new FilterStartsWithName(printer),
            new AddIfMax(printer), new RemoveGreater(printer), new Load(printer)
    };

    private final HashMap<String, BasicCommand> commandsHashMap = new HashMap<>();

    public IInvoker invoker = new CLInvoker();

    public Engine() {
        this.initCommandsHashMap();
    }

    /**
     * Запуск ввода команд
     */
    public void start(){invoker.mainCycle(this);}

    /**
     * Изменение источника команд
     * @param invoker источник команд
     */
    public void setInvoker(IInvoker invoker) {
        this.invoker = invoker;
        this.start();
    }

    /**
     * Инициализация таблицы сопоставления команд и классов
     */
    private void initCommandsHashMap() {
        for (BasicCommand command : this.commands) {
            this.commandsHashMap.put(command.getName(), command);
        }
    }

    /**
     * Получение списка команд
     * @return список команд
     */
    public BasicCommand[] getCommands() {
        return this.commands;
    }

    /**
     * Запуск команды
     * @param commandName имя команды
     * @param args аргументы команды
     */
    public void runCommand(String commandName, HashMap<String, String> args) {
        BasicCommand command = this.commandsHashMap.get(commandName);

        if (command == null) {
            logger.info("No command found with name {}", commandName);
            return;
        }

        try {
            command.execute(args, this);
        } catch (Exception err) {
            logger.debug("Error while executing command {}", commandName, err);
        }
    }
}
