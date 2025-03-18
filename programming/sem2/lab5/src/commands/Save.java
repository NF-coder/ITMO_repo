package commands;

import core.Structure;
import objects.City;

import java.util.HashMap;

public class Save extends BasicCommand {
    public Save() {
        super("save", "Сохранить коллекцию в файл" +
                "\n\t Example(DEBUG): save -file [String]");
    }

    public final void execute(HashMap<String, String> args) {
        Structure structure = new Structure();
        System.out.println(structure.toCSV());
    }
}