package server.network;

import server.network.drivers.INetworkDriver;
import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.io.*;
import java.util.Queue;


public class NetworkManager {
    INetworkDriver driver;
    INetworkSerializers serializer;

    public NetworkManager(INetworkDriver driver, INetworkSerializers serializer) {
        this.driver = driver;
        this.serializer = serializer;
        try{
            this.driver.init();
        }
        catch (Exception e){
            System.out.println("Error initializing network driver");
            System.out.println(e);
        }
    }

    public void send(Queue<NetworkContainer<NetworkResponseDTO>> outQueue) throws IOException{
        NetworkContainer<NetworkResponseDTO> r1 = outQueue.poll();
        if(r1 == null){return;}
        System.out.println(r1);

        this.driver.send(
                new NetworkContainer<> (
                        r1.socketAddress(),
                        this.serializer.serialize(
                                r1.data()
                        )
                )
        );
        System.out.println(r1);
    }
    public void receive(Queue<NetworkContainer<NetworkRequestDTO>> inpQueue) throws IOException, ClassNotFoundException{
        try {
            NetworkContainer<byte[]> nc = this.driver.receive();
            inpQueue.add(
                    new NetworkContainer<>(
                            nc.socketAddress(),
                            this.serializer.deserialize(
                                    nc.data()
                            )
                    )
            );
        }
        catch (Exception e){}
        /*catch (IOException err){
            //System.out.println("can't open connection");
        }
        catch (NullPointerException err){
            //System.out.println("no data received");
        }
        catch (ClassNotFoundException err){
            //System.out.println("can't deserialize object");
        }*/
    }
}
