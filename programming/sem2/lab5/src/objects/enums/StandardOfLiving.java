package objects.enums;

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
            case VERY_HIGH -> "HIGH";
            case HIGH -> "HIGH";
            case VERY_LOW -> "VERY_LOW";
            case ULTRA_LOW -> "ULTRA_LOW";
            case NIGHTMARE -> "NIGHTMARE";
        };
    }
}