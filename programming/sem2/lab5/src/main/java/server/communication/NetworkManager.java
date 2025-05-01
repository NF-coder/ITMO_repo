package server.communication;

import server.communication.drivers.INetworkDriver;
import server.communication.objects.NetworkDTO;

import java.io.*;
import java.util.Queue;
import java.util.function.Function;


public class NetworkManager {
    INetworkDriver driver;
    Function<Byte[], ?> inputSerializer;

    public NetworkManager(INetworkDriver driver, Function<Byte[], ?> inputSerializer) {
        this.driver = driver;
        this.inputSerializer = inputSerializer;
        try{
            this.driver.init();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void send(Queue<Object> outQueue) throws IOException{
        this.driver.send(
                this.serialize(
                        outQueue.poll()
                )
        );
    }
    public void receive(Queue<NetworkDTO> inpQueue) throws IOException, ClassNotFoundException{
        try {
            inpQueue.add(
                    this.deserialize(
                        this.driver.receive()
                )
            );
            Thread.sleep(1000);
        }
        catch (Exception e){
        }
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
