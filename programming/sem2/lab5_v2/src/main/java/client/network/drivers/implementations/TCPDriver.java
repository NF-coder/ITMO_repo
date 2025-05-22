package client.network.drivers.implementations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

import client.network.drivers.INetworkDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TCPDriver implements INetworkDriver {
    private final int myPort;
    private final int targetPort;

    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;

    private final Logger logger = LogManager.getLogger();

    public TCPDriver(int myPort, int targetPort) {
        this.myPort = myPort;
        this.targetPort = targetPort;
    }

    @Override
    public void init() {}

    private void socketInit() throws IOException {
        try{
            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", targetPort));
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            logger.debug("Connected to server on port {}", targetPort);
        }
        catch(ConnectException e){
            logger.warn("Failed to connect to server on port {}", targetPort);
            throw new IOException("Failed to connect to server on port " + targetPort);
        }
    }

    @Override
    public void send(byte[] data) throws IOException {
        if (socket == null || socket.isClosed() || !socket.isConnected()) socketInit();
        outputStream.write(data);
        outputStream.flush(); // Ensure all data is sent
        logger.debug("Data sent: {}", new String(data));
    }

    @Override
    public byte[] receive() throws IOException {
        if (socket == null || socket.isClosed()) {
            logger.error("Socket is not connected");
            throw new IOException("Socket is not connected.");
        }

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] temp = new byte[4096];
        int bytesRead;

        // Read data from the input stream
        while ((bytesRead = inputStream.read(temp)) != -1) {
            buffer.write(temp, 0, bytesRead);
            if (bytesRead < temp.length) {
                break; // Exit if no more data is available
            }
        }

        try{
            byte[] receivedData = buffer.toByteArray();
            logger.debug("Data received: {}", new String(receivedData));
            socket.close();
            return receivedData;
        }
        catch (Exception e){
            logger.error("Error while parsing data: {}", e.getMessage());
            throw new IOException("Error while parsing data", e);
        }

    }
}