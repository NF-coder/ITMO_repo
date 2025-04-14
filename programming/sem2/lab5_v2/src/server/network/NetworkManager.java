package server.network;

import server.network.drivers.INetworkDriver;

import java.io.*;
import java.net.*;

public class NetworkManager {
    INetworkDriver driver;
    public NetworkManager(INetworkDriver driver) {
        this.driver = driver;
    }

    private static byte[] serializer(Object obj)  {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.close();
            return bos.toByteArray();

        }
        catch (IOException e) {return null;}
    }
    private static Container deserialize(byte[] bytes) {
        if (bytes == null) return null;
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            logger.info("Команда успешно десериализована!");
            return (Container) ois.readObject();
        } catch (IOException e) {
            logger.error("Не удалось десереализовать объект");
            return null;
        } catch (ClassNotFoundException e) {
            logger.error("Не удалось десереализовать объект");
            return null;
        }
    }
}
