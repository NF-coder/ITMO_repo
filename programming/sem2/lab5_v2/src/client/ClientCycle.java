package client;

import server.network.NetworkDTO;
import server.network.NetworkManager;
import server.network.drivers.INetworkDriver;
import server.network.drivers.UDPDriver;

import java.util.HashMap;

public class Main implements Runnable{
    public void run(){
        UDPDriver driver = new UDPDriver(4055);
        NetworkManager networkManager = new NetworkManager(driver);

        HashMap<String,String> hamp = new HashMap<>();
        hamp.put("test", "t2");

        try {
            networkManager.send(
                    new NetworkDTO(
                            "op1",
                            hamp
                    )
            );
        }
        catch (Exception e){
            
        }
    }
}
