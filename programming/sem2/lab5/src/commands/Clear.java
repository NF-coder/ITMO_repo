package commands;

import workers.Engine;
import workers.Reciver;

import java.util.HashMap;

public class Clear extends BasicCommand{
    public Clear(){
        super("clear", "Clears all information about collection.");
    }

    public final void execute(HashMap<String, String> args){
        Reciver reciver = new Reciver();
        reciver.clearCollection();
        System.out.println("Success");
    }
}
