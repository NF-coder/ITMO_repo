package src.Character.Actions.Exceptons;

public class NegativePotatoesException extends Exception {
    public NegativePotatoesException() {
        super("Число картофелин не может быть отрицательным!");
    }
}
