package server.storage.commands.commands.reqArgs.primitive;

import org.json.JSONObject;

public class PrimitiveArgsBuilder {
    private final JSONObject jo = new JSONObject();

    public PrimitiveArgsBuilder setType(ArgTypesEnum type) {
        jo.put("type", type.toString());
        return this;
    }
    public <T> PrimitiveArgsBuilder setMin(T value) {
        jo.put("min", value);
        return this;
    }
    public <T> PrimitiveArgsBuilder setMax(T value) {
        jo.put("max", value);
        return this;
    }
    public <T> PrimitiveArgsBuilder addOptions(T[] options) {
        jo.put("options", options);
        return this;
    }

    public JSONObject get(){
        return jo;
    }
}
