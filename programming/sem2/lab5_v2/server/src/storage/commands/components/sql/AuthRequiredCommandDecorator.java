package storage.commands.components.sql;

import storage.collection.drivers.IStructDriver;
import storage.commands.commands.Command;
import storage.commands.components.sql.operations.DTOs.UserDTO;
import storage.commands.components.sql.operations.UsersTable;
import storage.objects.City;

import java.util.HashMap;

public class AuthRequiredCommandDecorator extends Command {
    private final Command command;

    public AuthRequiredCommandDecorator(Command command) {
        super(command.getName());
        this.command = command;
    }

    @Override
    public void setData(HashMap<String, String> args, IStructDriver driver) {
        this.command.setData(args, driver);
        this.args = args;
        System.out.println(args);
    }

    @Override
    public String call() throws Exception {
        Boolean result = SQLVault.connectionExecutor(
                new UsersTable()::check,
                new UserDTO(
                        args.get("login"),
                        args.get("password")
                )
        );

        if (result) {
            return command.call();
        }
        else {
            throw new Exception("Invalid login or password");
        }
    }
}
