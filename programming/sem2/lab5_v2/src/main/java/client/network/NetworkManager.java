package client.network;

import client.network.drivers.INetworkDriver;
import shared.objects.NetworkResponseDTO;

import java.io.*;

public class NetworkManager {
    INetworkDriver driver;
    public NetworkManager(INetworkDriver driver) {
        this.driver = driver;
        try {
            this.driver.init();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void send(Object obj) throws IOException{
        this.driver.send(
                this.serialize(obj)
        );
    }
    public NetworkResponseDTO receive() throws IOException, ClassNotFoundException{
        return this.deserialize(
                this.driver.receive()
        );
    }

    private byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
        return bos.toByteArray();
    }
    private NetworkResponseDTO deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        //if (bytes == null) return null;
        System.out.println(bytes);
        for (byte b: bytes){
            System.out.print(b + " ");
        }
        InputStream is = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(is);

        NetworkResponseDTO cached = (NetworkResponseDTO) ois.readObject();
        System.out.println(cached);
        return cached;
    }
}
