package server.network.serializers;

import java.io.IOException;

@FunctionalInterface
public interface INetworkDeserialize<T> {
    public T apply(byte[] data) throws IOException,ClassNotFoundException;
}
