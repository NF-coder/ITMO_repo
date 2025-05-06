package server.network.drivers;

import server.network.container.NetworkContainer;

import java.io.IOException;
import java.net.SocketException;

public interface INetworkDriver {
    public void init() throws SocketException, IOException;
    public void send(NetworkContainer<byte[]> data) throws IOException;
    public NetworkContainer<byte[]> receive() throws IOException;
}
