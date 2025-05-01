import server.ServerCycle;

public class Main {
    public static void main(String[] args) {
        ServerCycle cycle = new ServerCycle();
        Thread thread1 = new Thread(cycle);
        thread1.start();
    }
}