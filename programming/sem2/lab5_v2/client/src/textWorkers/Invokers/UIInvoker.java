package textWorkers.Invokers;

import core.Engine;
import textWorkers.Invoker;

import java.util.HashMap;
import java.util.Scanner;

public class UIInvoker implements IInvoker {
    private static final Invoker invoker = new Invoker();

    private static String opName;
    private static HashMap<String,String> inlineArgs;
    private static String[] opAdditionalArgs;
    private int opAdditionalArgsPtr = 0;
    private static boolean isReady = false;

    public void setInfo(String opName, HashMap<String,String> inlineArgs, String[] opAdditionalArgs) {
        UIInvoker.opName = opName;
        UIInvoker.inlineArgs = inlineArgs;
        UIInvoker.opAdditionalArgs = opAdditionalArgs;
        UIInvoker.isReady = true;
    }
    public void setInfo(String opName, HashMap<String,String> inlineArgs) {
        UIInvoker.opName = opName;
        UIInvoker.inlineArgs = inlineArgs;
        UIInvoker.isReady = true;
    }
    public void setInfo(String opName) {
        UIInvoker.opName = opName;
        UIInvoker.isReady = true;
    }

    public String parseFieldInput(String entryText){
        return opAdditionalArgs[opAdditionalArgsPtr++];
    }

    public void mainCycle(Engine engine) {
        opAdditionalArgsPtr = 0;
        while (!isReady) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        UIInvoker.isReady = false;
        invoker.run(opName, inlineArgs, engine);
    }
}
