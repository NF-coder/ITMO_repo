package ui;

import core.Engine;
import textWorkers.Invokers.UIInvoker;
import ui.utils.ReqController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        UIInvoker uiInvoker = new UIInvoker();
        ReqController reqController = new ReqController(uiInvoker);

        SwingUtilities.invokeLater(() -> new HelloLayout(reqController));

        engine.setInvoker(uiInvoker);
        engine.start();
    }
}
