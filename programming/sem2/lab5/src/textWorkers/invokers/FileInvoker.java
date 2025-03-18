package textWorkers.invokers;

import core.Engine;
import exceptions.FileProcessorException;
import textWorkers.Invoker;

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
            String line = FileInvoker.fileReader.readLine();
            System.out.println(line);
            return line;
        }
        catch (IOException err){
            //throw new FileProcessorException("Can't read file");
        }
        return "placeholder for compiler";
    }

    public void mainCycle(Engine engine) {
        try{
            while (true) {
                String line = FileInvoker.fileReader.readLine();
                if (line == null){
                    return;
                }
                invoker.run(line, engine);
            }
        }
        catch (IOException err){}
        catch (NullPointerException err){}

    }
}
