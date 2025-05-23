package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.exceptions.UnacceptableValue;

import java.util.HashMap;

public class Clear extends Command {
    public Clear(){
        super("clear");
    }
    public String call() throws UnacceptableValue {
        driver.clearCollection();
        return null;
    }
}
