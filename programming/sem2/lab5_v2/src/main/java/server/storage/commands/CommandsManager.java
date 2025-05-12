package server.storage.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import server.storage.collection.drivers.IStructDriver;
import server.storage.commands.commands.Command;
import server.storage.commands.commands.implementations.Add;
import server.storage.commands.commands.implementations.Clear;
import server.storage.commands.commands.implementations.FilterStartsWithName;
import server.storage.commands.commands.implementations.Info;
import server.storage.commands.commands.implementations.RemoveAllByStandardOfLiving;
import server.storage.commands.commands.implementations.RemoveById;
import server.storage.commands.commands.implementations.RemoveFirst;
import server.storage.commands.commands.implementations.Save;
import server.storage.commands.commands.implementations.Show;
import server.storage.commands.commands.implementations.Update;
import server.storage.objects.City;

public class CommandsManager{
    private final IStructDriver driver;
    HashMap<String, Command> opTable = new HashMap<>();
    private final Command[] opArr = {
            new Add(), new Update(), new Clear(), new FilterStartsWithName(),
            new RemoveAllByStandardOfLiving(), new RemoveById(),
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
    private JSONObject getMetaInfo(){
        return Arrays.stream(this.opArr)
                .collect(
                        JSONObject::new,
                        (obj, elem) -> obj.accumulate(elem.getName(), elem.getArgs()),
                        (obj, elem) -> {}
                );
    }

    public CompletableFuture<JSONObject> run(String command, HashMap<String,String> args) {
        if (command.equals("init")){
            return CompletableFuture.supplyAsync(
                    this::getMetaInfo
            );
        }
        Command cmd = opTable.get(command);
        cmd.setData(args, driver);
        return CompletableFuture.supplyAsync(
                cmd
        );
    }
}