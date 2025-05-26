package network.drivers;

import network.container.NetworkContainer;

import java.io.IOException;

@FunctionalInterface
public interface NetDriverSend<T>{
    void send(NetworkContainer<byte[], T> data) throws IOException;
}
