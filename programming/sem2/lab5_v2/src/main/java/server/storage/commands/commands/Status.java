package server.storage.commands.commands;

public enum Status {
    OK,
    ERROR;

    @Override
    public String toString() {
        return switch (this) {
            case OK -> "OK";
            case ERROR -> "ERROR";
        };
    }
}
