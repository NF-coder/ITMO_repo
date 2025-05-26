package storage.commands.commands.implementations;

import storage.commands.components.Vault;
import storage.commands.commands.Command;

import java.io.IOException;

public class Load extends Command {
    Vault vault;
    public Load(Vault vault) {
        super("load");
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
