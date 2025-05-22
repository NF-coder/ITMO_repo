package server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder;

import server.storage.commands.commands.argsBuilder.PrimitiveArgsBuilder.implementations.ArgTypesEnum;

public interface IPrimitiveArgsBuilder<R> {
    IPrimitiveArgsBuilder<R> start();
    IPrimitiveArgsBuilder<R> setType(ArgTypesEnum type);
    <T> IPrimitiveArgsBuilder<R> setMin(T value);
    <T> IPrimitiveArgsBuilder<R> setMax(T value);
    <T> IPrimitiveArgsBuilder<R> addOptions(T[] options);
    R get();
}


