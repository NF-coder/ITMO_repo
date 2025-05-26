package commands.implementations.parsers;

import commands.exceptions.UnacceptableValue;
import textWorkers.Invokers.IInvoker;

import java.util.Objects;


/**
 * Авотматический повторный пар
 */
public class LoopedParse {
    public static String parse(String entryText, IInvoker invoker, CheckedConsumer<String> validator) throws InterruptedException{
        while (true) {
            try {
                String data = invoker.parseFieldInput(entryText);
                if (Objects.equals(data, "quit")) throw new InterruptedException("Exit called with quit");
                if (validator != null) validator.accept(data);
                return data;
            } catch (UnacceptableValue e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
