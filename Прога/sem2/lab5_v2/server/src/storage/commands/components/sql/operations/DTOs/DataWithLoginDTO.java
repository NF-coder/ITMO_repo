package storage.commands.components.sql.operations.DTOs;

public record DataWithLoginDTO<T> (T data, String login) {}