package server.storage.commands.commands.implementations;

import server.storage.collection.vault.Vault;
import server.storage.commands.commands.Command;
import server.storage.objects.exceptions.UnacceptableValue;

import java.io.IOException;
import java.util.stream.Collectors;

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
