package commands.implementations.components.output;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Система вывода полученных в результате выполнения команды данных
 */
public class CommandOutput {
    private static final Logger logger = LogManager.getLogger();

    public static void primitivePrinter(JSONObject res){
        System.out.println("RESULT STATUS: " + res.get("status") + "\n"
        + "RESULT: " + res.get("result"));
    }
    public static void logger(JSONObject res){
        logger.info("RESULT STATUS: {}\nRESULT: {}", res.get("status"), res.get("result"));
    }
    public static void loggerAndPrinter(JSONObject res){
        System.out.println("RESULT STATUS: " + res.get("status") + "\n"
                + "RESULT: " + res.get("result"));
        logger.info("RESULT STATUS: {}\nRESULT: {}", res.get("status"), res.get("result"));
    }
}
