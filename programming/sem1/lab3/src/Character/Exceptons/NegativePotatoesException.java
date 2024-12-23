package src.Character.Exceptons;

public class NegativePotatoesException extends Exception {
    public NegativePotatoesException() {
        super("Число картофелин не может быть отрицательным!");
    }
}
