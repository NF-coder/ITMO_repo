package commands;

import objects.templates.converters.Converters;
import storage.Structure;

import java.util.HashMap;

public class RemoveById extends BasicCommand{
    public RemoveById(){
        super("remove_by_id", "Удаляет элемент по идентификатору"  +
                "\n\t Example: remove_by_id -id [Long]");
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();
        structure.removeById(
                Converters.StringToLong(args.get("id"))
        );
    }
}
