package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilder;
import server.storage.objects.exceptions.UnacceptableValue;

import java.util.HashMap;

public class RemoveById extends Command {
    public RemoveById(){
        super(
                "remove_by_id",
                new ArgsBuilder()
                        .addInteger("id", 0L, null)
        );
    }
    public String call() throws UnacceptableValue {
        this.driver.removeById(
                Long.valueOf(
                        this.args.get("id")
                )
        );
        return null;
    }
}
