package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.objects.exceptions.UnacceptableValue;

import java.util.HashMap;

public class RemoveFirst extends Command {
    public RemoveFirst(){
        super("remove_first");
    }
    public String call() throws UnacceptableValue {
        driver.removeFirst();
        return null;
    }
}
