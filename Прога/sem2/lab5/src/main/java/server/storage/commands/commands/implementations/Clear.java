package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.exceptions.UnacceptableValue;

public class Clear extends Command<Void> {
    public Clear(){
        super("clear");
    }
    public Void call() throws UnacceptableValue {
        driver.clearCollection();
        return null;
    }
}
