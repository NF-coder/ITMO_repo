package commands;

import workers.Reciver;

import java.util.HashMap;

public class Show extends BasicCommand{
    public Show(){
        super("show", "Shows all entities from collection.");
    }

    public final void execute(HashMap<String, String> args){
        Reciver reciver = new Reciver();
        System.out.println(reciver.getAllEntities());
    }
}
