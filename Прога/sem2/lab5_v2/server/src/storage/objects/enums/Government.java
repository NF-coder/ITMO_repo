package storage.objects.enums;

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

    public int getCost() {
        return switch (this) {
            case DEMARCHY -> 0;
            case DICTATORSHIP, COMMUNISM -> 1;
            case JUNTA -> -3;
        };
    }
}