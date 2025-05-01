package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.City;

import java.util.stream.Collectors;

public class Save extends Command {
    public Save() {
        super("save");
    }
    public String call(){
        String javaHome = System.getenv("COLLECTION_HOME");

        return this.driver.getCollection().stream()
                .map(City::toCSVString)
                .collect(Collectors.joining("\n"));
    }
}
