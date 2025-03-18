package commands;

import core.Structure;

import java.util.HashMap;

public class RemoveAllByStandardOfLiving extends BasicCommand{
    public RemoveAllByStandardOfLiving(){
        super("remove_all_by_standard_of_living", "Удаляет все элементы с заданным качеством жизни"  +
                "\n\t Example: remove_all_by_standard_of_living -standardOfLiving [String]");
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();
        structure.removeAllByStandardOfLiving(
                args.get("standardOfLiving")
        );
    }
}
