package ui;

import core.Engine;
import textWorkers.Invokers.UIInvoker;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        UIInvoker uiInvoker = new UIInvoker();

        MapLayout thread = new MapLayout();
        //thread.uiInvoker = uiInvoker;
        thread.run();

        engine.setInvoker(uiInvoker);
        engine.start();
    }
}
