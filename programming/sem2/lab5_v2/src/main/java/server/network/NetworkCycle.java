package server.network;

import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.util.Queue;

public class NetworkCycle implements Runnable{
    private final NetworkManager nm;
    public final Queue<NetworkRequestDTO> inpQueue;
    public final Queue<NetworkResponseDTO> outQueue;

    public NetworkCycle(
            INetworkDriver nd,
            INetworkSerializers serializer,
            Queue<NetworkRequestDTO> inpQueue,
            Queue<NetworkResponseDTO> outQueue
    ){
        this.nm = new NetworkManager(
                nd,
                serializer
        );
        this.inpQueue = inpQueue;
        this.outQueue = outQueue;
    }
    public void run(){
        while (true){
            try {
                this.nm.receive(inpQueue);
                this.nm.send(outQueue);
            }
            catch (Exception e){ }
        }
    }
}
