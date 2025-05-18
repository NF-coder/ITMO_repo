package server.storage.commands;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import server.storage.collection.drivers.IStructDriver;
import server.storage.collection.vault.Vault;
import server.storage.commands.commands.Command;
import server.storage.commands.commands.implementations.*;

public class CommandsManager {
    private final IStructDriver driver;
    HashMap<String, Command> opTable = new HashMap<>();
    private final Command[] opArr = {
            new Add(), new Update(), new Clear(), new FilterStartsWithName(),
            new RemoveAllByStandardOfLiving(), new RemoveById(),
            new RemoveFirst(), new Show(), new Info(), new Save(new Vault()),
            new AddIfMax(), new RemoveGreater(), new Load(new Vault()), new AvgOfMetersAboveSea()
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
        for (Command op : this.opArr) {
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