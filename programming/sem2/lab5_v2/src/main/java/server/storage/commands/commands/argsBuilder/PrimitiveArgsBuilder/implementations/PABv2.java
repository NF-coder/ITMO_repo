package server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.implementations;

import server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.IPrimitiveArgsBuilder;

import java.util.Arrays;
import java.util.HashMap;

public class PABv2 implements IPrimitiveArgsBuilder<HashMap<String,String>> {
    private HashMap<String,String> jo;

    public PABv2 start(){
        jo = new HashMap<>();
        return this;
    }

    @Override
    public PABv2 setType(ArgTypesEnum type) {
        jo.put("type", type.toString());
        return this;
    }

    @Override
    public <T> PABv2 setMin(T value) {
        jo.put("min", value.toString());
        return this;
    }

    @Override
    public <T> PABv2 setMax(T value) {
        jo.put("max", value.toString());
        return this;
    }

    @Override
    public <T> PABv2 addOptions(T[] options) {
        jo.put("options", Arrays.toString(options));
        return this;
    }

    @Override
    public HashMap<String,String> get(){
        return jo;
    }
}
