package storage.commands;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;
import storage.collection.drivers.IStructDriver;
import storage.commands.components.sql.AuthRequiredCommandDecorator;
import storage.commands.commands.Command;
import storage.commands.commands.implementations.*;
import storage.commands.components.sql.StructWithSQLDriverDecorator;

public class CommandsManager {
    private final IStructDriver driver;
    HashMap<String, Command> opTable = new HashMap<>();

    private final Command[] authedOpArr = {
            new Add(), new Update(), new Clear(), new FilterStartsWithName(),
            new RemoveAllByStandardOfLiving(), new RemoveById(),
            new RemoveFirst(), new Show(), new Info(),
            new AddIfMax(), new RemoveGreater(), new AvgOfMetersAboveSea()
    };
    private final Command[] nonAuthedOpArr = {
            new Register()
    };

    /**
     * @param driver Драйвер структуры данных
     */
    public CommandsManager(IStructDriver driver) {
        this.driver = driver;
        this.initOpTable();
    }

    /**
     * Инициализация хэш-таблицы сопоставлений имён и команд
     */
    private void initOpTable() {
        for (Command op : this.authedOpArr) {
            this.opTable.put(op.getName(), new AuthRequiredCommandDecorator(op));
        }
        for (Command op : this.nonAuthedOpArr) {
            this.opTable.put(op.getName(), op);
        }
    }

    /**
    * Запуск команды
     * @param command имя команды
     * @param args аргументы для команды
     * @return результат работы команды
     */
    public CompletableFuture<JSONObject> run(String command, HashMap<String, String> args) {
        Command cmd = opTable.get(command);
        cmd.setData(args, driver);
        System.out.println("Executing command: " + cmd.getName());
        return CompletableFuture.supplyAsync(
                cmd
        );
    }
}