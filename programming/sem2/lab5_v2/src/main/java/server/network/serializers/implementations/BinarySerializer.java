package server.network.serializers.implementations;

import server.network.serializers.INetworkSerializers;
import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.io.*;

public class BinarySerializer implements INetworkSerializers<NetworkResponseDTO<Serializable>, NetworkRequestDTO> {
    public byte[] serialize(NetworkResponseDTO<Serializable> data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(data);
        oos.close();
        return bos.toByteArray();
    }
    public NetworkRequestDTO deserialize(byte[] data) throws IOException, ClassNotFoundException {
        //if (bytes == null) return null;
        InputStream is = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(is);
        return (NetworkRequestDTO) ois.readObject();
    }
}
