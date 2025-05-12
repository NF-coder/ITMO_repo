package server.network.serializers;

import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.io.IOException;
import java.io.Serializable;

public interface INetworkSerializers {
    public <S> byte[] serialize(S data) throws IOException;
    public <D> D deserialize(byte[] data) throws IOException, ClassNotFoundException;
}
