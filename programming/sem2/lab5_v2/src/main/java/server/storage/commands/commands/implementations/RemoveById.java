package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;
import server.storage.objects.exceptions.UnacceptableValue;

public class RemoveById extends Command {
    public RemoveById(){
        super(
                "remove_by_id",
                new ArgsBuilderV2()
                        .putInteger("id",0L,null)
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
