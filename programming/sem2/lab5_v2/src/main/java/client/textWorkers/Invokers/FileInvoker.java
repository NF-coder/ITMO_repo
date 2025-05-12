package client.textWorkers.Invokers;


import client.commands.exceptions.FileProcessorException;
import client.core.Engine;
import client.textWorkers.Invoker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.AccessControlException;

public class FileInvoker implements IInvoker{
    private static final Invoker invoker = new Invoker();
    static BufferedReader fileReader;

    public FileInvoker(String filename) throws FileProcessorException {
        try {
            FileReader fileReader = new FileReader(filename);
            FileInvoker.fileReader = new BufferedReader(fileReader);
        }
        catch (FileNotFoundException err){
            throw new FileProcessorException("Файл " + filename + " не найден!");
        }
        catch (AccessControlException err){ // ?
            throw new FileProcessorException("Недостаточно прав для доступа к " + filename);
        }
    }

    public String parseFieldInput(String entryText){
        System.out.print(entryText + ": ");

        try {
            String input = FileInvoker.fileReader.readLine();
            try {
                System.out.println(input);
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return input;
        }
        catch (IOException ignored){}

        return "placeholder for compiler";
    }

    public void mainCycle(Engine engine) {
        try{
            while (true) {
                String line = FileInvoker.fileReader.readLine();
                System.out.println(line);
                invoker.run(line, engine);
            }
        }
        catch (IOException ignored){}
    }
}
