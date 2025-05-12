package client.commands.implementations.parsers;

import client.commands.exceptions.UnacceptableValue;
import client.textWorkers.Invokers.IInvoker;


public class LoopedParse {
    public static String parse(String entryText, IInvoker invoker, CheckedConsumer<String> validator) {
        while (true) {
            try {
                String data = invoker.parseFieldInput(entryText);
                if (validator != null) validator.accept(data);
                return data;
            } catch (UnacceptableValue e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
