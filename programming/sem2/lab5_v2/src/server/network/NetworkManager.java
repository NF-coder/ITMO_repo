package server.network;

import server.network.drivers.INetworkDriver;

import java.io.*;
import java.net.*;

public class NetworkManager {
    INetworkDriver driver;
    public NetworkManager(INetworkDriver driver) {
        this.driver = driver;
        try{
            this.driver.init();
        }
        catch (Exception e){

        }
    }

    public void send(Object obj) throws IOException{
        this.driver.send(
                this.serialize(obj)
        );
    }
    public NetworkDTO recive() throws IOException, ClassNotFoundException{
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
    private NetworkDTO deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        //if (bytes == null) return null;
        InputStream is = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(is);
        return (NetworkDTO) ois.readObject();
    }
}
