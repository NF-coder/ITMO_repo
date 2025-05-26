package storage.commands.commands.implementations;

import storage.commands.components.Vault;
import storage.commands.commands.Command;
import storage.objects.City;

import java.io.*;
import java.util.stream.Collectors;

public class Save extends Command {
    Vault vault;
    public Save(Vault vault) {
        super("save");
        this.vault = vault;
    }
    public String call(){
        try {
            vault.save(
                    this.driver.getCollection().stream()
                            .map(City::toCSVString)
                            .collect(Collectors.joining("\n"))
            );
        }
        catch (IOException ignored) {
            return "an error occurred while writing to the file";
        }

        return null;
    }
}
