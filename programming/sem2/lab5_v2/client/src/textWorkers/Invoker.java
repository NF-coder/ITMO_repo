package textWorkers;

import core.Engine;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Класс, отвечающий за токенизацию входной информации
 */
public class Invoker {
    /**
     * Разделение строки на команду и аргументы
     * @param line строка
     * @param engine движок клиента
     */
    public void run(String line, Engine engine) {
        String[] tokens = line.split(" ");

        String command = tokens[0];
        String[] argsArr = Arrays.copyOfRange(tokens, 1, tokens.length);

        engine.runCommand(
                command,
                this.parseArgs(argsArr)
        );
    }

    public void run(String opName, HashMap<String,String> inlineArgs, Engine engine) {
        engine.runCommand(
                opName,
                inlineArgs
        );
    }

    /**
     * Парсинг аргументов
     * @param tokens массив токенов (аргументы и их значения)
     * @return Результат парсинга
     */
    private HashMap<String, String> parseArgs(String[] tokens){
        HashMap<String,String> parsedArguments = new HashMap<>();

        String argName = "";
        StringBuilder argValue = new StringBuilder();
        for (String token: tokens){
            if (token.charAt(0) == '-'){
                if (!argName.isEmpty()){
                    parsedArguments.put(argName.substring(1), argValue.toString());
                    argValue = new StringBuilder();
                }
                argName = token;
            }
            else{
                if (!argValue.isEmpty()){
                    argValue.append(" ");
                }
                argValue.append(token);
            }
        }
        if (!argName.isEmpty()){
            parsedArguments.put(argName.substring(1), argValue.toString());
        }
        return parsedArguments;
    }


    // For Debug
    private void printTokens(String[] tokens){
        int idx = 0;
        for (String token : tokens) {
            System.out.print("Token #" + idx + ": ");
            System.out.println(token);
            idx++;
        }
    }
}
