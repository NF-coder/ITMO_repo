package network.drivers.implementations;

import network.drivers.INetworkDriver;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public final class UDPDriver implements INetworkDriver {
    int myPort;
    int targetPort;

    DatagramChannel channel;
    SocketAddress myAddr;
    SocketAddress targetAddr;
    private final int PACKET_SIZE = 1024;
    private final int DATA_SIZE = PACKET_SIZE - 1;

    public UDPDriver(int myPort, int targetPort) {
        this.myPort = myPort;
        this.targetPort = targetPort;
    }

    @Override
    public void init() throws SocketException, IOException{
        myAddr = new InetSocketAddress(myPort);
        targetAddr = new InetSocketAddress(targetPort);

        channel = DatagramChannel.open();
        channel.bind(myAddr);
        channel.configureBlocking(true);
    }

    @Override
    public void send(byte[] data) throws IOException, ConnectException {
        ByteBuffer buf = ByteBuffer.wrap(data);
        channel.send(buf, targetAddr);
    }

    @Override
    public byte[] receive() throws IOException{
        ByteBuffer buf = ByteBuffer.allocate(DATA_SIZE);
        SocketAddress addr = channel.receive(buf);

        if (addr != null)  return buf.array();
        return null;
    }
}
