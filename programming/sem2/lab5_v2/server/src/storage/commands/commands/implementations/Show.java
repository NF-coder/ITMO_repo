package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;

import java.util.stream.Collectors;

public class Show extends Command {
    public Show() {
        super("show");
    }
    public String call(){
        return this.driver.getCollection().stream()
                .map(Object::toString)
                .collect(Collectors.joining(",\n"));
    }
}
