package client.commands.objects.enums;

/**
 * Допустимые значения качества жизни
 */
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
}