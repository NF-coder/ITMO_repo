package client.commands.implementations.components.output;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * Система вывода полученных в результате выполнения команды данных
 */
public class CommandOutput {
    public static void primitivePrinter(HashMap<String,String> res){
        System.out.println("RESULT STATUS: " + res.get("status") + "\n"
        + "RESULT: " + res.get("result"));
    };
}
