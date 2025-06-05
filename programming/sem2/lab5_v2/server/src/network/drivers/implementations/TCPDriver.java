package network.drivers.implementations;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import network.container.NetworkContainer;
import network.drivers.INetworkDriver;

public class TCPDriver implements INetworkDriver<SocketChannel> {
    private final int port;
    private ServerSocketChannel serverChannel;
    private final int PACKET_SIZE = 1024;
    private final Logger logger = LogManager.getLogger();

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
                data.connInfo().write(buffer);
            }
            logger.debug("Data sent to {}", data.connInfo());
        } catch (IOException e) {
            logger.debug("Error while sending data: {}", String.valueOf(e));
            throw e;
        }
        catch (Exception e) {
            logger.warn("Unhandled exception: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public NetworkContainer<byte[], SocketChannel> receive() throws IOException {

        try{
            System.out.println("Waiting for connection...");
            SocketChannel clientChannel = serverChannel.accept();
            System.out.println("Connection accepted");
            logger.debug("Client connected: {}", clientChannel.getRemoteAddress());
            System.out.println(clientChannel.getRemoteAddress());

            ByteBuffer buffer = ByteBuffer.allocate(PACKET_SIZE);

            int bytesRead = clientChannel.read(buffer);

            if (bytesRead == -1) {
                throw new IOException("Client closed the connection.");
            }

            logger.debug("Data received from client: {}", new String(buffer.array()));
            return new NetworkContainer<>(clientChannel, buffer.array());
        } catch (IOException e) {
            logger.debug("Error while receiving data: {}", e.getMessage());
            throw e;
        }
    }
}