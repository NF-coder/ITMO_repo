package server.network;

import server.network.drivers.INetworkDriver;
import server.network.objects.NetworkDTO;

import java.util.Queue;

public class NetworkCycle implements Runnable{
    private final NetworkManager nm;
    public final Queue<NetworkDTO> inpQueue;
    public final Queue<Object> outQueue;

    public NetworkCycle(INetworkDriver nd, Queue<NetworkDTO> inpQueue, Queue<Object> outQueue){
        this.nm = new NetworkManager(nd);
        this.inpQueue = inpQueue;
        this.outQueue = outQueue;
    }
    public void run(){
        while (true){
            try {
                this.nm.receive(inpQueue);
                this.nm.send(outQueue);
            }
            catch (Exception e){

            }
        }
    }
}
