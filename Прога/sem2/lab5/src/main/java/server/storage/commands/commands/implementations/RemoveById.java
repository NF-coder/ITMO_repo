package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.exceptions.UnacceptableValue;

public class RemoveById extends Command<Void> {
    public RemoveById(){
        super("remove_by_id");
    }
    public Void call() throws UnacceptableValue {
        this.driver.removeById(
                Long.valueOf(
                        this.args.get("id")
                )
        );
        return null;
    }
}
