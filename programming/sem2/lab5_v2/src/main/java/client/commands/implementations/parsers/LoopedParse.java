package client.commands.implementations.parsers;
import client.textWorkers.Invokers.IInvoker;

public class LoopedParse {
    public String parse(String entryText, IInvoker invoker) {

        while (true){
            try{
                String res = invoker.parseFieldInput(entryText);
            }
            catch (Exception e){

            }
        }

    }
}
