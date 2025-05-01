package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.exceptions.UnacceptableValue;

import java.util.HashMap;

public class Op1 extends Command {
    public Op1(){
        super("op1");
    }
    public String call() throws UnacceptableValue {
        System.out.println("Op1 executed");
        return "ok";
    }
}
