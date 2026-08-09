package storage.commands.commands.implementations;

import org.json.JSONObject;
import storage.commands.commands.Command;
import storage.objects.City;
import storage.objects.Coordinates;
import storage.objects.Human;

public class Info extends Command {
    public Info() {
        super("info");
    }

    public JSONObject call() throws Exception{
        return this.driver.getJSON();
    }
}
