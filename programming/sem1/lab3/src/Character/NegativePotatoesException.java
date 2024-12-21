package src.Character;

public class NegativePotatoesException extends Exception {
    public NegativePotatoesException() {
        super("Число картофелин не может быть отрицательным!");
    }
}
