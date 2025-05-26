package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.commands.components.sql.CheckOwner;
import storage.objects.exceptions.UnacceptableValue;


public class RemoveById extends Command {
    public RemoveById(){
        super("remove_by_id");
    }
    public String call() throws UnacceptableValue {
        if (!CheckOwner.apply(this.args.get("id"), this.args.get("login"))){
            throw new UnacceptableValue("You're not owner");
        }
        this.driver.removeById(
                Long.valueOf(
                        this.args.get("id")
                )
        );
        return null;
    }
}
