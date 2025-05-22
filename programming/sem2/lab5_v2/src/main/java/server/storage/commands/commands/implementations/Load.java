package server.storage.commands.commands.implementations;

import server.storage.collection.vault.Vault;
import server.storage.commands.commands.Command;
import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;

import java.io.IOException;

public class Load extends Command {
    Vault vault;

    public Load(Vault vault) {
        super(
                "load",
                new ArgsBuilderV2()
        );
        this.vault = vault;
    }
    public String call(){
        try {
            vault.load(this.driver);
        }
        catch (IOException ignored) {
            return "an error occurred while reading file";
        }

        return null;
    }
}
