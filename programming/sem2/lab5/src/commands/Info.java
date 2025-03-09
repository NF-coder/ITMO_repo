package commands;

import workers.Reciver;

import java.util.HashMap;

public class Info extends BasicCommand{
    public Info(){
        super("info", "Returns information about Collection.");
    }

    public final void execute(HashMap<String, String> args){
        Reciver reciver = new Reciver();
        System.out.println(reciver);
    }
}
