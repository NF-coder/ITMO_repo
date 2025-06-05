package storage.commands.commands.implementations;

import org.json.JSONObject;
import storage.commands.commands.Command;
import storage.commands.components.sql.CheckOwner;
import storage.commands.components.sql.SQLVault;
import storage.commands.components.sql.operations.CollectionTable;
import storage.objects.exceptions.UnacceptableValue;

import java.sql.SQLException;
import java.util.HashMap;

public class RemoveFirst extends Command {
    public RemoveFirst(){
        super("remove_first");
    }
    public JSONObject call() throws UnacceptableValue {

        try{
            Long cityId = SQLVault.connectionExecutor(
                    new CollectionTable()::getFirstElemInfo,
                    null
            ).cityId();
            if (!CheckOwner.apply(cityId, this.args.get("login"))){
                throw new UnacceptableValue("You're not owner");
            }
            driver.removeById(cityId);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            throw new UnacceptableValue("Can't find first element. Maybe collection empty?");
        }
        return null;
    }
}
