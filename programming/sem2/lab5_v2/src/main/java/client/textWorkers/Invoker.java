package client.textWorkers;

import client.core.Engine;
import java.util.Arrays;
import java.util.HashMap;

public class Invoker {
    Engine engine = new Engine();

    public void run(String line){
        String[] tokens = line.split(" ");

        String command = tokens[0];
        String[] argsArr = Arrays.copyOfRange(tokens, 1, tokens.length);

        this.engine.runCommand(
                command,
                this.parseArgs(argsArr)
        );
    }

    private HashMap<String, String> parseArgs(String[] tokens){
        HashMap<String,String> parsedArguments = new HashMap<>();

        String argName = "";
        String argValue = "";
        for (String token: tokens){
            if (token.charAt(0) == '-'){
                if (!argName.isEmpty()){
                    parsedArguments.put(argName.substring(1), argValue);
                    argValue = "";
                }
                argName = token;
            }
            else{
                if (!argValue.isEmpty()){
                    argValue = argValue + " ";
                }
                argValue = argValue + token;
            }
        }
        if (!argName.isEmpty()){
            parsedArguments.put(argName.substring(1), argValue);
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
