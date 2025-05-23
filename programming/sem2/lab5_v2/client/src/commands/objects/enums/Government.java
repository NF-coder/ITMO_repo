package commands.objects.enums;

/**
 * Допустимые значения типа правительства в городе
 */
public enum Government implements EnumInterface{
    DEMARCHY,
    DICTATORSHIP,
    COMMUNISM,
    JUNTA;

    public static final String name = "Тип правительства";

    @Override
    public String toString() {
        return switch (this) {
            case DEMARCHY -> "DEMARCHY";
            case DICTATORSHIP -> "DICTATORSHIP";
            case COMMUNISM -> "COMMUNISM";
            case JUNTA -> "JUNTA";
        };
    }
}