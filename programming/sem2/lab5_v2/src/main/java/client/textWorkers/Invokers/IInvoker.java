package client.textWorkers.Invokers;

import client.core.Engine;

public interface IInvoker {
    public String parseFieldInput(String entryText);
    public void mainCycle(Engine engine);
}
