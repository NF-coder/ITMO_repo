package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.exceptions.UnacceptableValue;

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
