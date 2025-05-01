package client;

import server.communication.objects.NetworkDTO;
import client.network.NetworkManager;
import client.network.drivers.UDPDriver;

import java.util.HashMap;

public class ClientCycle implements Runnable{
    public void run(){
        UDPDriver driver = new UDPDriver(4056);
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
            System.out.println("sended");
            Thread.sleep(1000);
            NetworkDTO nmr = networkManager.recive();
            System.out.println(nmr);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
