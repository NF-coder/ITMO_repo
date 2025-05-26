package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.objects.exceptions.UnacceptableValue;

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
