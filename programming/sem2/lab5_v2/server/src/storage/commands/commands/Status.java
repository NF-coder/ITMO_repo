package storage.commands.commands;

/**
 * Статус выполнения команды
 */
public enum Status {
    /**
     * Успешно выполнена
     */
    OK,
    /**
     * Прервана с ошибкой
     */
    ERROR;

    @Override
    public String toString() {
        return switch (this) {
            case OK -> "OK";
            case ERROR -> "ERROR";
        };
    }
}
