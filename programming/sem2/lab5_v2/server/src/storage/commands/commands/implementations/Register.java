package storage.commands.commands.implementations;

import org.json.JSONObject;
import storage.commands.commands.Command;
import storage.commands.components.sql.SQLVault;
import storage.commands.components.sql.operations.DTOs.UserDTO;
import storage.commands.components.sql.operations.UsersTable;

public class Register extends Command {

    public Register() {
        super("register");
    }

    public JSONObject call() throws Exception{
        this.logger.debug("Registering user");

        SQLVault.connectionExecutor(
                new UsersTable()::addUser,
                new UserDTO(this.args.get("login"), this.args.get("password"))
        );
        return null;
    }
}
