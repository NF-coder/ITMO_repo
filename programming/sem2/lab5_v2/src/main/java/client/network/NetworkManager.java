package client.network;

import client.network.drivers.INetworkDriver;
import shared.objects.NetworkResponseDTO;

import java.io.*;
import java.util.Arrays;

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
    public NetworkResponseDTO<byte[]> receive() throws IOException, ClassNotFoundException{
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
    private NetworkResponseDTO<byte[]> deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        //if (bytes == null) return null;
        //System.out.println(Arrays.toString(bytes));
        //for (byte b: bytes) System.out.print(b + " ");

        InputStream is = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(is);

        NetworkResponseDTO<byte[]> cached = (NetworkResponseDTO<byte[]>) ois.readObject();
        //System.out.println(cached);
        return cached;
    }
}
