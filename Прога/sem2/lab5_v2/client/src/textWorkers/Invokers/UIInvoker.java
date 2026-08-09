package textWorkers.Invokers;

import core.Engine;
import textWorkers.Invoker;

import java.util.HashMap;
import java.util.Scanner;

public class UIInvoker implements IInvoker {
    private final Invoker invoker = new Invoker();

    private String opName;
    private HashMap<String,String> inlineArgs;
    private String[] opAdditionalArgs;
    private int opAdditionalArgsPtr = 0;
    private boolean isReady = false;

    public void setInfo(String opName, HashMap<String,String> inlineArgs, String[] opAdditionalArgs) {
        this.opName = opName;
        this.inlineArgs = inlineArgs;
        this.opAdditionalArgs = opAdditionalArgs;
        this.isReady = true;
    }
    public void setInfo(String opName, HashMap<String,String> inlineArgs) {
        System.out.println("Sinfo signal");

        this.opName = opName;
        this.inlineArgs = inlineArgs;
        this.isReady = true;
    }
    public void setInfo(String opName) {
        this.opName = opName;
        this.isReady = true;
    }

    public String parseFieldInput(String entryText){
        return opAdditionalArgs[opAdditionalArgsPtr++];
    }

    public void mainCycle(Engine engine) {
        while (true){
            opAdditionalArgsPtr = 0;
            while (!isReady)
                Thread.yield();
            this.isReady = false;
            System.out.println("Sinfo signal");
            invoker.run(opName, inlineArgs, engine);
        }

    }
}
