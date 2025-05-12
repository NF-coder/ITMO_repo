package client.commands.objects.validators.np;

@FunctionalInterface
public interface CheckedBasicParser<T, R> {
    R accept(T t) throws NumberFormatException, IllegalArgumentException;
}