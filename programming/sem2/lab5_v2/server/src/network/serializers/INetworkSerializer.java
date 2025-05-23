package server.network.serializers;

import shared.objects.NetworkResponseDTO;

import java.io.IOException;

@FunctionalInterface
public interface INetworkSerializer {
    public byte[] apply(NetworkResponseDTO data) throws IOException;
}
