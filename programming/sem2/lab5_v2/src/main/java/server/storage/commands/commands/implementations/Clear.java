package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;
import server.storage.objects.exceptions.UnacceptableValue;

public class Clear extends Command {
    public Clear(){
        super(
                "clear",
                new ArgsBuilderV2()
        );
    }
    public String call() throws UnacceptableValue {
        driver.clearCollection();
        return null;
    }
}
