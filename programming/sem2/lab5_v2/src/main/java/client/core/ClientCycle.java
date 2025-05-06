package client.core;

import shared.objects.NetworkRequestDTO;
import client.network.NetworkManager;
import client.network.drivers.UDPDriver;
import shared.objects.NetworkResponseDTO;

import java.util.HashMap;

public class ClientCycle implements Runnable{
    public void run(){
        UDPDriver driver = new UDPDriver(4059,4056);
        NetworkManager networkManager = new NetworkManager(driver);

        HashMap<String,String> hamp = new HashMap<>();
        hamp.put("test", "t2");

        try {
            networkManager.send(
                    new NetworkRequestDTO(
                            "op1",
                            hamp
                    )
            );
            System.out.println("sended");
            //Thread.sleep(1000);
            NetworkResponseDTO nmr = networkManager.receive();
            System.out.println(nmr);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
