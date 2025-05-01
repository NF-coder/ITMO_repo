package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.exceptions.UnacceptableValue;

public class Op1 extends Command<Void> {
    public Op1(){
        super("op1");
    }
    public Void call() throws UnacceptableValue {
        System.out.println("Op1 executed");
        return null;
    }
}
