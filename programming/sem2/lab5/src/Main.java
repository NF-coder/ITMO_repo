import core.Engine;
import textWorkers.invokers.CLInvoker;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Engine.setActiveInvoker(new CLInvoker());
        engine.start();
    }
}