package storage.commands.components.sql.operations;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface SQLFunction<T,R> {
    public R apply(Connection connection, T t) throws SQLException;
}
