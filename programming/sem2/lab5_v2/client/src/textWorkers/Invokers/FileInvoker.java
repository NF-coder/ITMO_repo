package textWorkers.Invokers;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import commands.exceptions.FileProcessorException;
import core.Engine;
import textWorkers.Invoker;

public class FileInvoker implements IInvoker{
    private static final Invoker invoker = new Invoker();
    static BufferedReader fileReader;

    public FileInvoker(String filename) throws FileProcessorException {
        try {
            FileInvoker.fileReader = new BufferedReader(new FileReader(filename));
        }
        catch (FileNotFoundException err){
            throw new FileProcessorException("Файл " + filename + " не найден!");
        }
        catch (SecurityException err){ // Handle insufficient access rights
            throw new FileProcessorException("Недостаточно прав для доступа к " + filename);
        }
    }

    public String parseFieldInput(String entryText){
        System.out.print(entryText + ": ");

        try {
            String input = FileInvoker.fileReader.readLine();
            System.out.println(input);
            return input;
        }
        catch (IOException ignored){}

        return "placeholder for compiler";
    }

    public void mainCycle(Engine engine) {
        FileInvoker.fileReader.lines().forEach(
                (line) -> {
                    System.out.println(line);
                    invoker.run(line, engine);
                }
        );
    }
}
