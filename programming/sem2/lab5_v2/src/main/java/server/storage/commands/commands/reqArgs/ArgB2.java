package server.storage.commands.commands.reqArgs;

import org.json.JSONObject;

import java.util.HashMap;

public class ArgB2 {
    private final JSONObject jo = new JSONObject();

    public ArgB2 setType(ArgTypesEnum type) {
        jo.put("type", type.toString());
        return this;
    }
    public <T> ArgB2 setMin(T value) {
        jo.put("min", value);
        return this;
    }
    public <T> ArgB2 setMax(T value) {
        jo.put("max", value);
        return this;
    }
    public <T> ArgB2 addOptions(T[] options) {
        jo.put("options", options);
        return this;
    }

    public JSONObject get(){
        return jo;
    }
}
