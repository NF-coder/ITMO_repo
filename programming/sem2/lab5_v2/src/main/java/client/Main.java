package client;

import client.textWorkers.Invokers.CLInvoker;

public class Main {
    public static void main(String[] args) {
        CLInvoker invoker = new CLInvoker();
        invoker.mainCycle();
    }
}