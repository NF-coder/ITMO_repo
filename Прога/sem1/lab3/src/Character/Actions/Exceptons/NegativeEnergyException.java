package src.Character.Actions.Exceptons;

public class NegativeEnergyException extends Exception {
    public NegativeEnergyException() {
        super("У персонажа недостаточно энергии для совершения действия!");
    }
}
