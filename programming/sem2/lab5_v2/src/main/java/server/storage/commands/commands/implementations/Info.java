package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;

public class Info extends Command {
    public Info() {
        super("info");
    }

    public String call() throws Exception{
        return this.driver.toString();
    }
}
