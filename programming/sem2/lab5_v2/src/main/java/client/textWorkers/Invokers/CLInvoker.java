package client.textWorkers.Invokers;


import client.core.Engine;
import client.textWorkers.Invoker;

import java.util.Scanner;

public class CLInvoker implements IInvoker{
    private static final Scanner input = new Scanner(System.in);
    private static final Invoker invoker = new Invoker();

    public String parseFieldInput(String entryText){
        System.out.print(entryText + ": ");
        return CLInvoker.input.nextLine();
    }

    public void mainCycle(Engine engine) {
        while (CLInvoker.input.hasNextLine()) {
            String line = CLInvoker.input.nextLine();
            invoker.run(line, engine);
        }
    }
}
