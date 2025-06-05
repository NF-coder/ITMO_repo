package ui;

import core.Engine;
import textWorkers.Invokers.UIInvoker;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();

        HelloLayout ui = new HelloLayout();
        ui.run();

        engine.setInvoker(ui.uiInvoker);
        engine.start();
    }
}
