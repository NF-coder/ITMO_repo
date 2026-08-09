package storage.commands.commands.implementations;

import org.json.JSONObject;
import storage.commands.commands.Command;
import storage.objects.exceptions.UnacceptableValue;

import java.util.HashMap;

public class Clear extends Command {
    public Clear(){
        super("clear");
    }
    public JSONObject call() throws UnacceptableValue {
        driver.clearCollection();
        return null;
    }
}
