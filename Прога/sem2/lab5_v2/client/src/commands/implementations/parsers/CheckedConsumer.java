package commands.implementations.parsers;

import commands.exceptions.UnacceptableValue;

@FunctionalInterface
public interface CheckedConsumer<T> {
    void accept(T t) throws UnacceptableValue;
}