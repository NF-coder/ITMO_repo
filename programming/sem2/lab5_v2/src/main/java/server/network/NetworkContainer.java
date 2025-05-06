package server.network;

import java.net.SocketAddress;

public record NetworkContainer<T> (SocketAddress socketAddress, T data) {}
