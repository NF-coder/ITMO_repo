import client.ClientCycle;
import server.ServerCycle;

public class Main {
    public static void main(String[] args) {
        ServerCycle cycle = new ServerCycle();
        Thread thread = new Thread(cycle);
        thread.start();
    }
}