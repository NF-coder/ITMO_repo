package client.network.drivers;

import java.io.IOException;
import java.lang.annotation.Target;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPDriver implements INetworkDriver {
    int myPort;
    int targetPort;

    DatagramChannel channel;
    SocketAddress myAddr;
    SocketAddress targetAddr;
    private final int PACKET_SIZE = 4096;
    private final int DATA_SIZE = PACKET_SIZE - 1;

    public UDPDriver(int myPort, int targetPort) {
        this.myPort = myPort;
        this.targetPort = targetPort;
    }

    public void init() throws SocketException, IOException{
        myAddr = new InetSocketAddress(myPort);
        targetAddr = new InetSocketAddress(targetPort);

        channel = DatagramChannel.open();
        channel.bind(myAddr);
        channel.configureBlocking(true);
    }

    public void send(byte[] data) throws IOException {
        ByteBuffer buf = ByteBuffer.wrap(data);
        channel.send(buf, targetAddr);
    }

    public byte[] receive() throws IOException{
        ByteBuffer buf = ByteBuffer.allocate(DATA_SIZE);

        //System.out.println("receiving...");
        //System.out.println(buf);

        SocketAddress addr = channel.receive(buf);

        //System.out.println("received: " + addr);

        if (addr != null) {
            //System.out.println("receive buffer dump");
            return buf.array();
        }
        return null;
    }
}
