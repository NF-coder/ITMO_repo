package server.network.serializers.implementations;

import org.json.JSONObject;
import server.network.serializers.INetworkSerializers;

import java.nio.charset.StandardCharsets;

public class JsonSerializer implements INetworkSerializers<JSONObject, JSONObject> {
    public byte[] serialize(JSONObject data){
        return data.toString().getBytes();
    }
    public JSONObject deserialize(byte[] data){
        String res = new String(data, StandardCharsets.UTF_8);;
        return new JSONObject(res);
    }
}
