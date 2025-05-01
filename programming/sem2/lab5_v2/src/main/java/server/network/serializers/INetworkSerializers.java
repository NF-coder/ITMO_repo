package server.network.serializers;

import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.io.IOException;

public interface INetworkSerializers {
    public byte[] serialize(NetworkResponseDTO data) throws IOException;
    public NetworkRequestDTO deserialize(byte[] data) throws IOException, ClassNotFoundException;
}
