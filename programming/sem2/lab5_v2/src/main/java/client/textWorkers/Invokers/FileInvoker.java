package client.textWorkers.Invokers;


import client.commands.exceptions.FileProcessorException;
import client.textWorkers.Invoker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.AccessControlException;

public class FileInvoker implements IInvoker{
    private static Invoker invoker = new Invoker();
    static BufferedReader fileReader;

    public void FileInvoker(String filename) throws FileProcessorException {
        try {
            FileReader fileReader = new FileReader(filename);
            this.fileReader = new BufferedReader(fileReader);
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
            return FileInvoker.fileReader.readLine();
        }
        catch (IOException err){
            //throw new FileProcessorException("Can't read file");
        }
        return "placeholder for compiler";
    }

    public void mainCycle() {
        try{
            while (true) {
                String line = FileInvoker.fileReader.readLine();
                invoker.run(line);
            }
        }
        catch (IOException err){}

    }
}
