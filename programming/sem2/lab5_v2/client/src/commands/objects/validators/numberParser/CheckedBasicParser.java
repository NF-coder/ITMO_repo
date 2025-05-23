package commands.objects.validators.numberParser;

@FunctionalInterface
public interface CheckedBasicParser<T, R> {
    R accept(T t) throws IllegalArgumentException;
}