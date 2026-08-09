package storage.objects.enums;

/**
 * Допустимые климаты городов
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

    public int getCost() {
        return switch (this) {
            case OCEANIC -> 2;
            case MEDITERRANIAN -> 1;
            case SUBARCTIC -> -1;
        };
    }
}