package commands;

import core.Structure;

import java.util.HashMap;

public class RemoveFirst extends BasicCommand{
    public RemoveFirst(){
        super("remove_first", "Удаляет самый ранее добавленный элемент");
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();
        structure.removeFirst();
    }
}
