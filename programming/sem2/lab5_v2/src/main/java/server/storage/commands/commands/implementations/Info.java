package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.City;
import server.storage.objects.Coordinates;
import server.storage.objects.Human;

public class Info extends Command {
    public Info() {
        super("info");
    }

    public String call() throws Exception{
        return this.driver.toString();
    }
}
