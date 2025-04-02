package objects.enums;

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