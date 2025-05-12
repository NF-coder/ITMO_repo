package client.textWorkers;

import client.core.Engine;
import java.util.Arrays;
import java.util.HashMap;

public class Invoker {

    public void run(String line, Engine engine) {
        String[] tokens = line.split(" ");

        String command = tokens[0];
        String[] argsArr = Arrays.copyOfRange(tokens, 1, tokens.length);

        engine.runCommand(
                command,
                this.parseArgs(argsArr)
        );
    }

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
