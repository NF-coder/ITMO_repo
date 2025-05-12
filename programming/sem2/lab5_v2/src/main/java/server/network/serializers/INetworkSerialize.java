package server.network.serializers;

import java.io.IOException;

@FunctionalInterface
public interface INetworkSerialize<T> {
    public byte[] apply(T data) throws IOException;
}
