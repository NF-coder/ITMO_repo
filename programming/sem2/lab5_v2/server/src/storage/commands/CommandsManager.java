package storage.commands;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import storage.collection.drivers.IStructDriver;
import storage.commands.components.sql.AuthRequiredCommandDecorator;
import storage.commands.components.Vault;
import storage.commands.commands.Command;
import storage.commands.commands.implementations.*;
import storage.commands.components.sql.StructWithSQLDriverDecorator;

public class CommandsManager {
    private final IStructDriver driver;
    HashMap<String, Command> opTable = new HashMap<>();

    private final Command[] authedOpArr = {
            new Add(), new Update(), new Clear(), new FilterStartsWithName(),
            new RemoveAllByStandardOfLiving(), new RemoveById(),
            new RemoveFirst(), new Show(), new Info(), new Save(new Vault()),
            new AddIfMax(), new RemoveGreater(), new Load(new Vault()), new AvgOfMetersAboveSea()
    };
    private final Command[] nonAuthedOpArr = {
            new Register()
    };

    /**
     * @param driver Драйвер структуры данных
     */
    public CommandsManager(IStructDriver driver) {
        this.driver = new StructWithSQLDriverDecorator(driver);
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
    public CompletableFuture<HashMap<String, String>> run(String command, HashMap<String, String> args) {
        Command cmd = opTable.get(command);
        cmd.setData(args, driver);
        return CompletableFuture.supplyAsync(
                cmd
        );
    }
}