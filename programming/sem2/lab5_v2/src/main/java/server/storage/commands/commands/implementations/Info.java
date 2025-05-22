package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;

public class Info extends Command {
    public Info() {
        super(
                "info",
                new ArgsBuilderV2()
        );
    }

    public String call() throws Exception{
        return this.driver.toString();
    }
}
