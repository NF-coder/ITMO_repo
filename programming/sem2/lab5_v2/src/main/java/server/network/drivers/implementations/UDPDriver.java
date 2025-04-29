package server.network.drivers.implementations;

import server.network.drivers.INetworkDriver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPDriver implements INetworkDriver {
    DatagramChannel channel;
    int port;
    SocketAddress addr;
    private final int PACKET_SIZE = 1024;
    private final int DATA_SIZE = PACKET_SIZE - 1;

    public UDPDriver(int port) {
        this.port = port;
    }

    public void init() throws SocketException, IOException{
        addr = new InetSocketAddress(port);
        channel = DatagramChannel.open();
        channel.bind(addr);
        channel.configureBlocking(false);
    }

    public void send(byte[] data) throws IOException {
        ByteBuffer buf = ByteBuffer.wrap(data);
        channel.send(buf, addr);
    }

    public byte[] receive() throws IOException{
        ByteBuffer buf = ByteBuffer.allocate(DATA_SIZE);
        addr = channel.receive(buf);
        if (addr != null) {
            return buf.array();
        }
        return null;
    }
}
