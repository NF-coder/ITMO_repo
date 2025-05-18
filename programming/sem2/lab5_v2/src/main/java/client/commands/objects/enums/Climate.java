package client.commands.objects.enums;

/**
 * Допустимые значения климата города
 */
public enum Climate implements EnumInterface {
    OCEANIC,
    MEDITERRANIAN,
    SUBARCTIC;

    public static final String name = "Тип климата";

    @Override
    public String toString() {
        return switch (this) {
            case OCEANIC -> "OCEANIC";
            case MEDITERRANIAN -> "MEDITERRANIAN";
            case SUBARCTIC -> "SUBARCTIC";
        };
    }
}