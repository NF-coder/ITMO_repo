package server.network.drivers.implementations;

import server.network.drivers.INetworkDriver;
import server.network.container.NetworkContainer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPDriver implements INetworkDriver<SocketAddress> {
    DatagramChannel channel;
    int port;
    SocketAddress addr;
    private final int PACKET_SIZE = 1024;
    private final int DATA_SIZE = PACKET_SIZE - 1;

    public UDPDriver(int port) {
        this.port = port;
    }

    @Override
    public void init() throws IOException{
        addr = new InetSocketAddress(port);
        channel = DatagramChannel.open();
        channel.bind(addr);
        channel.configureBlocking(true);
    }

    @Override
    public void send(NetworkContainer<byte[], SocketAddress> data) throws IOException {
        ByteBuffer buf = ByteBuffer.wrap(data.data());
        channel.send(buf, data.connInfo());
    }

    @Override
    public NetworkContainer<byte[], SocketAddress> receive() throws IOException{
        ByteBuffer buf = ByteBuffer.allocate(DATA_SIZE);
        addr = channel.receive(buf);
        if (addr != null) {
            return new NetworkContainer<>(
                    addr,
                    buf.array()
            );
        }
        return null;
    }
}
