package client.network.drivers;

import java.io.IOException;
import java.net.SocketException;

public interface INetworkDriver {
    public void init() throws SocketException, IOException;
    public void send(byte[] data) throws IOException;
    public byte[] receive() throws IOException;
}
