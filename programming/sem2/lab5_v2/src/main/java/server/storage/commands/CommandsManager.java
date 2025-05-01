package server.storage.commands;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.implementations.*;
import server.storage.collection.drivers.IStructDriver;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CommandsManager {
    private final IStructDriver driver;
    HashMap<String, Command> opTable = new HashMap<>();
    private final Command[] opArr = {
            new Add(), new Update(), new Clear(), new FilterStartsWithName(),
            new Op1(), new RemoveAllByStandardOfLiving(), new RemoveById(),
            new RemoveFirst(), new Show(), new Info(), new Save()
    };

    public CommandsManager(IStructDriver driver){
        this.driver = driver;
        this.initOpTable();
    }

    private void initOpTable(){
        for (Command op: this.opArr){
            this.opTable.put(op.getName(), op);
        }
    }

    public CompletableFuture<HashMap<String,String>> run(String command, HashMap<String,String> args, ExecutorService exec) throws Exception {
        Command cmd = opTable.get(command);
        cmd.setData(args, driver);
        return CompletableFuture.supplyAsync(
                cmd,
                exec
        );
    }
}