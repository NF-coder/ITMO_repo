package server.storage.commands.commands.argsBuilder;

import org.json.JSONObject;
import server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.PrimitiveArgsBuilder;
import server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.ArgTypesEnum;
import server.storage.objects.enums.EnumInterface;

import java.util.Arrays;

public class ArgsBuilder {
    private final JSONObject args = new JSONObject();

    public ArgsBuilder addInteger(String name) {
        args.put(
                name,
                new PrimitiveArgsBuilder()
                        .setType(ArgTypesEnum.INTEGER)
                        .get()
        );
        return this;
    }
    public ArgsBuilder addInteger(String name, Long min, Long max) {
        PrimitiveArgsBuilder AB2 = new PrimitiveArgsBuilder();
        if (min != null) AB2.setMin(min);
        if (max != null) AB2.setMax(max);
        args.put(name, AB2.get());
        return this;
    }

    public ArgsBuilder addReal(String name) {
        args.put(
                name,
                new PrimitiveArgsBuilder()
                        .setType(ArgTypesEnum.REAL)
                        .get()
        );
        return this;
    }
    public ArgsBuilder addReal(String name, Double min, Double max) {
        PrimitiveArgsBuilder AB2 = new PrimitiveArgsBuilder();
        if (min != null) AB2.setMin(min);
        if (max != null) AB2.setMax(max);
        args.put(name, new PrimitiveArgsBuilder().get());
        return this;
    }

    public ArgsBuilder addEnum(String name, Class<? extends EnumInterface> e) {
        args.put(
                name,
                new PrimitiveArgsBuilder()
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
                new PrimitiveArgsBuilder()
                        .setType(ArgTypesEnum.STRING)
                        .get()
        );
        return this;
    }
    public ArgsBuilder addDate(String name) {
        args.put(
                name,
                new PrimitiveArgsBuilder()
                        .setType(ArgTypesEnum.DATE)
                        .get()
        );
        return this;
    }

    public JSONObject get() {
        return args;
    }
}