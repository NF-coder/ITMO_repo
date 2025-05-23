package server.storage.objects.enums;

public enum StandardOfLiving implements EnumInterface{
    VERY_HIGH,
    HIGH,
    VERY_LOW,
    ULTRA_LOW,
    NIGHTMARE;

    public static final String name = "Стандарт качества жизни";

    @Override
    public String toString() {
        return switch (this) {
            case VERY_HIGH -> "VERY_HIGH";
            case HIGH -> "HIGH";
            case VERY_LOW -> "VERY_LOW";
            case ULTRA_LOW -> "ULTRA_LOW";
            case NIGHTMARE -> "NIGHTMARE";
        };
    }

    public int getCost() {
        return switch (this) {
            case VERY_HIGH -> 2;
            case HIGH -> 1;
            case VERY_LOW -> -3;
            case ULTRA_LOW -> -4;
            case NIGHTMARE -> -5;
        };
    }
}