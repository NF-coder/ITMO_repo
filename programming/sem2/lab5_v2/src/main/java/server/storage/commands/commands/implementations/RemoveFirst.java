package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;
import server.storage.objects.exceptions.UnacceptableValue;

public class RemoveFirst extends Command {
    public RemoveFirst(){
        super(
                "remove_first",
                new ArgsBuilderV2()
        );
    }
    public String call() throws UnacceptableValue {
        driver.removeFirst();
        return null;
    }
}
