package server.network;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.util.Queue;

public class NetworkCycle implements Runnable{
    private final NetworkManager nm;
    public final Queue<NetworkContainer<NetworkRequestDTO>> inpQueue;
    public final Queue<NetworkContainer<NetworkResponseDTO>> outQueue;

    public NetworkCycle(
            INetworkDriver nd,
            INetworkSerializers serializer,
            Queue<NetworkContainer<NetworkRequestDTO>> inpQueue,
            Queue<NetworkContainer<NetworkResponseDTO>> outQueue
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
