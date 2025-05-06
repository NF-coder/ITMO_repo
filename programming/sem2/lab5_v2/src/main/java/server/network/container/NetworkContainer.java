package server.network.container;

import java.net.SocketAddress;

public record NetworkContainer<T> (SocketAddress socketAddress, T data) {}
