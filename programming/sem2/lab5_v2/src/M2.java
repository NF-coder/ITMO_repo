import client.ClientCycle;
import server.ServerCycle;

public class M2 {
    public static void main(String[] args) {
        ClientCycle c_cycle = new ClientCycle();
        Thread thread2 = new Thread(c_cycle);
        thread2.start();
    }
}