package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.exceptions.UnacceptableValue;

public class RemoveFirst extends Command<Void> {
    public RemoveFirst(){
        super("remove_first");
    }
    public Void call() throws UnacceptableValue {
        driver.removeFirst();
        return null;
    }
}
