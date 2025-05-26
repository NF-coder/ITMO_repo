package network.serializers;

import shared.objects.NetworkRequestDTO;

import java.io.IOException;

@FunctionalInterface
public interface INetworkDeserializer {
    public NetworkRequestDTO apply(byte[] data) throws IOException, ClassNotFoundException;
}
