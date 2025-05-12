package server.storage.commands.commands.reqArgs;

import org.json.JSONObject;
import server.storage.objects.enums.EnumInterface;

import java.util.Arrays;
import java.util.HashMap;

public class ArgsBuilder {
    private final JSONObject args = new JSONObject();

    public ArgsBuilder addInteger(String name) {
        args.put(
                name,
                new ArgB2()
                        .setType(ArgTypesEnum.INTEGER)
                        .get()
        );
        return this;
    }
    public ArgsBuilder addInteger(String name, Long min, Long max) {
        ArgB2 AB2 = new ArgB2();
        if (min != null) AB2.setMin(min);
        if (max != null) AB2.setMax(max);
        args.put(name, AB2.get());
        return this;
    }

    public ArgsBuilder addReal(String name) {
        args.put(
                name,
                new ArgB2()
                        .setType(ArgTypesEnum.REAL)
                        .get()
        );
        return this;
    }
    public ArgsBuilder addReal(String name, Double min, Double max) {
        ArgB2 AB2 = new ArgB2();
        if (min != null) AB2.setMin(min);
        if (max != null) AB2.setMax(max);
        args.put(name, new ArgB2().get());
        return this;
    }

    public ArgsBuilder addEnum(String name, Class<? extends EnumInterface> e) {
        args.put(
                name,
                new ArgB2()
                        .setType(ArgTypesEnum.ENUM)
                        .addOptions(
                                Arrays.stream(e.getEnumConstants())
                                        .map(Object::toString)
                                        .toArray(String[]::new))
                        .get()
        );
        return this;
    }
    public ArgsBuilder addString(String name) {
        args.put(
                name,
                new ArgB2()
                        .setType(ArgTypesEnum.STRING)
                        .get()
        );
        return this;
    }
    public ArgsBuilder addDate(String name) {
        args.put(
                name,
                new ArgB2()
                        .setType(ArgTypesEnum.DATE)
                        .get()
        );
        return this;
    }

    public JSONObject get() {
        return args;
    }
}