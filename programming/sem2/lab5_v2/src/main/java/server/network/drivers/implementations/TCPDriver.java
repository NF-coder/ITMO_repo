package server.network.drivers.implementations;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import server.network.container.NetworkContainer;
import server.network.drivers.INetworkDriver;

public class TCPDriver implements INetworkDriver<SocketChannel> {
    private final int port;
    private ServerSocketChannel serverChannel;
    private final int PACKET_SIZE = 1024;

    public TCPDriver(int port) {
        this.port = port;
    }


    @Override
    public void init() throws IOException {
        // Инициализация ServerSocketChannel
        serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(port));
        serverChannel.configureBlocking(true); // Блокирующий режим
    }


    @Override
    public void send(NetworkContainer<byte[], SocketChannel> data) throws IOException {
        try {
            ByteBuffer buffer = ByteBuffer.wrap(data.data());
            while (buffer.hasRemaining()) {
                data.connInfo().write(buffer); // Ensure all data is written
            }
            System.out.println("Data sent to " + data.connInfo());
        } catch (IOException e) {
            System.err.println("Error while sending data: " + e);
            throw e;
        }
        catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    @Override
    public NetworkContainer<byte[], SocketChannel> receive() throws IOException {

        try{
            SocketChannel clientChannel = serverChannel.accept();
            System.out.println("Client connected: " + clientChannel.getRemoteAddress());

            ByteBuffer buffer = ByteBuffer.allocate(PACKET_SIZE);
            int bytesRead = clientChannel.read(buffer);

            if (bytesRead == -1) {
                throw new IOException("Client closed the connection.");
            }

            buffer.flip(); // Prepare buffer for reading
            byte[] receivedData = new byte[buffer.remaining()];
            buffer.get(receivedData);

            System.out.println("Data received from client: " + new String(receivedData));
            return new NetworkContainer<>(clientChannel, receivedData);
        } catch (IOException e) {
            System.err.println("Error while receiving data: " + e.getMessage());
            throw e;
        }
    }
}