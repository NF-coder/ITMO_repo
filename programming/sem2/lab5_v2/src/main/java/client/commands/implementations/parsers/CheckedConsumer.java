package client.commands.implementations.parsers;

import client.commands.exceptions.UnacceptableValue;

@FunctionalInterface
public interface CheckedConsumer<T> {
    void accept(T t) throws UnacceptableValue;
}