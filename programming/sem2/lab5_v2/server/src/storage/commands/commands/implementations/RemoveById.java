package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.objects.exceptions.UnacceptableValue;

import java.util.HashMap;

public class RemoveById extends Command {
    public RemoveById(){
        super("remove_by_id");
    }
    public String call() throws UnacceptableValue {
        this.driver.removeById(
                Long.valueOf(
                        this.args.get("id")
                )
        );
        return null;
    }
}
