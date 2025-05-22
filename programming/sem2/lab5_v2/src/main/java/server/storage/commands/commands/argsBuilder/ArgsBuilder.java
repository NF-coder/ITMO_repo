package server.storage.commands.commands.argsBuilder;

import server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.IPrimitiveArgsBuilder;
import server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.implementations.ArgTypesEnum;
import server.storage.objects.enums.EnumInterface;

import java.util.Arrays;
import java.util.HashMap;

public class ArgsBuilder<T> {
    private final HashMap<String,T> args = new HashMap<>();
    IPrimitiveArgsBuilder<T> primitiveArgsBuilder;

    public ArgsBuilder (IPrimitiveArgsBuilder<T> primitiveArgsBuilder) {
        this.primitiveArgsBuilder = primitiveArgsBuilder;
    }

    public ArgsBuilder<T> addInteger(String name) {
        args.put(
                name,
                primitiveArgsBuilder.start()
                        .setType(ArgTypesEnum.INTEGER)
                        .get()
        );
        return this;
    }

    public ArgsBuilder<T> addInteger(String name, Long min, Long max) {
        IPrimitiveArgsBuilder<T> AB2 = primitiveArgsBuilder.start().setType(ArgTypesEnum.INTEGER);
        if (min != null) AB2.setMin(min);
        if (max != null) AB2.setMax(max);
        args.put(name, AB2.get());
        return this;
    }

    public ArgsBuilder<T> addReal(String name) {
        args.put(
                name,
                primitiveArgsBuilder.start()
                        .setType(ArgTypesEnum.REAL)
                        .get()
        );
        return this;
    }
    public ArgsBuilder<T> addReal(String name, Double min, Double max) {
        IPrimitiveArgsBuilder<T> AB2 = primitiveArgsBuilder.start().setType(ArgTypesEnum.REAL);
        if (min != null) AB2.setMin(min);
        if (max != null) AB2.setMax(max);
        args.put(name, AB2.get());
        return this;
    }

    public ArgsBuilder<T> addEnum(String name, Class<? extends EnumInterface> e) {
        args.put(
                name,
                primitiveArgsBuilder.start()
                        .setType(ArgTypesEnum.ENUM)
                        .addOptions(
                                Arrays.stream(e.getEnumConstants())
                                        .map(Object::toString)
                                        .toArray(String[]::new))
                        .get()
        );
        return this;
    }
    public ArgsBuilder<T> addString(String name) {
        args.put(
                name,
                primitiveArgsBuilder.start()
                        .setType(ArgTypesEnum.STRING)
                        .get()
        );
        return this;
    }
    public ArgsBuilder<T> addDate(String name) {
        args.put(
                name,
                primitiveArgsBuilder.start()
                        .setType(ArgTypesEnum.DATE)
                        .get()
        );
        return this;
    }

    public HashMap<String,T> get() {
        return args;
    }
}