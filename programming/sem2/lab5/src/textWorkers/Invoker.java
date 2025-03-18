package textWorkers;

import core.Engine;

import java.util.Arrays;
import java.util.HashMap;

public class Invoker {
    /**
     * Метод, разбивающий строку на команду и токены
     * @param line Строка-команда
     */
    public void run(String line, Engine engine){
        String[] tokens = line.split(" ");

        String command = tokens[0]; // команда
        String[] argsArr = Arrays.copyOfRange(tokens, 1, tokens.length); // массив токенов

        engine.runCommand(
                command,
                this.parseArgs(argsArr) // расшифровка токенов
        );
    }

    /**
     * Метод, выделяющий из массива токенов аргументы и их значения
     * @param tokens Строка-команда
     * @return HashMap<String, String>
     */
    private HashMap<String, String> parseArgs(String[] tokens){
        HashMap<String,String> parsedArguments = new HashMap<>();

        String argName = ""; // имя аргумента
        String argValue = ""; // строка, аккумулирующая значение аргумента
        for (String token: tokens){
            if (token.charAt(0) == '-'){ // проверка на то, является ли токен именем аргумента
                if (!argName.isEmpty()){ // если до этого в строке с именем аргумента уже лежал один, то парсинг финализируется
                    parsedArguments.put(argName.substring(1), argValue);
                    argValue = "";
                }
                argName = token; // установка имени нового аргумента, начало парсинга его значения
            }
            else{ // если строка не является именем аргумента...
                if (!argValue.isEmpty()){ // избегаем лишнего пробела в начале парсинга значения аргумента
                    argValue = argValue + " "; // восстановление пробела
                }
                argValue = argValue + token; // добавление токена к значению аргумента
            }
        }
        if (!argName.isEmpty()){ // парсинг последнего аргумента и его значения
            parsedArguments.put(argName.substring(1), argValue);
        }
        return parsedArguments;
    }


    /**
     * DEBUG
     * Этот метод используется для вывода внутреннего состояния парсера
     * @param tokens Список токенов
     */
    private void printTokens(String[] tokens){
        int idx = 0;
        for (String token : tokens) {
            System.out.print("Token #" + idx + ": ");
            System.out.println(token);
            idx++;
        }
    }
}
