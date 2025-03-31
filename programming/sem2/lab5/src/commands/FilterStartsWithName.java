package commands;

import storage.Structure;
import objects.City;

import java.util.HashMap;

public class FilterStartsWithName extends BasicCommand{
    public FilterStartsWithName(){
        super("filter_starts_with_name", "Выводит элементы, значение поля name которых начинается с заданной подстроки"  +
                "\n\t Example: filter_starts_with_name -name [String]");
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();
        for (City elem: structure.getAllEntities()){
            if (elem.getName().indexOf(args.get("name")) == 0) {
                System.out.println(elem);
            }
        }
    }
}
