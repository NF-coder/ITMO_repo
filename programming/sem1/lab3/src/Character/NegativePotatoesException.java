package src.Character;

public class NegativePotatoesException extends RuntimeException {
    public NegativePotatoesException() {
        super("Число картофелин не может быть отрицательным!");
    }
}
