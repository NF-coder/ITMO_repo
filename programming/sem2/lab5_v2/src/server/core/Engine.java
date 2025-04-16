package server.core;

import server.core.promise.Promise;
import server.core.promise.mappers.ToPromise;
import server.network.NetworkDTO;
import server.network.NetworkManager;
import server.network.drivers.UDPDriver;

import java.util.function.Function;

public class Engine {
    private final NetworkManager network;

    public Engine(){
        UDPDriver driver = new UDPDriver(4055);
        this.network = new NetworkManager(driver);
    }

    public void mainCycle(){
        try{
            Function<NetworkDTO, Promise> conv1 = ToPromise::fromNetworkDTO;
            Promise p1 = conv1.apply(this.network.recive());
            System.out.println(p1);

        }
        catch (Exception e){

        }
    }
}
