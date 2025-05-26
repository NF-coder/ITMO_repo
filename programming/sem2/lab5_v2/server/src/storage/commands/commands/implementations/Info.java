package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.objects.City;
import storage.objects.Coordinates;
import storage.objects.Human;

public class Info extends Command {
    public Info() {
        super("info");
    }

    public String call() throws Exception{
        return this.driver.toString();
    }
}
