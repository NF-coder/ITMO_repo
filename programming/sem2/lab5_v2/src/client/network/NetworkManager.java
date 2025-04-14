package client.network;

import client.network.drivers.INetworkDriver;

import java.io.*;

public class NetworkManager {
    INetworkDriver driver;
    public NetworkManager(INetworkDriver driver) {
        this.driver = driver;
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
        if (bytes == null) return null;
        InputStream is = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(is);
        return (NetworkDTO) ois.readObject();
    }
}
