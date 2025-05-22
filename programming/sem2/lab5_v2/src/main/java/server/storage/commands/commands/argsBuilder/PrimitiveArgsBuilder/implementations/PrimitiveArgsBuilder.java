package server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.implementations;

import org.json.JSONObject;
import server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.IPrimitiveArgsBuilder;

public class PrimitiveArgsBuilder implements IPrimitiveArgsBuilder<JSONObject> {
    private JSONObject jo;

    public PrimitiveArgsBuilder start() {
        jo = new JSONObject();
        return this;
    }

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
