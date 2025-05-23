package server.storage.commands.commands.argsBuilder.primitive;

public enum ArgTypesEnum {
    INTEGER,
    REAL,
    STRING,
    DATE,
    ENUM;

    @Override
    public String toString() {
        return switch (this) {
            case INTEGER -> "INTEGER";
            case REAL -> "REAL";
            case STRING -> "STRING";
            case DATE -> "DATE";
            case ENUM -> "ENUM";
        };
    }
}
