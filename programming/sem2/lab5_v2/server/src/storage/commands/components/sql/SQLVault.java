package storage.commands.components.sql;

import storage.commands.components.sql.operations.SQLFunction;
import storage.objects.exceptions.UnacceptableValue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLVault {
    public static <T,R> R connectionExecutor(SQLFunction<T,R> fn, T data) throws SQLException {
        try(Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5459/db",
                "release", "horse_ate_green_guinea_pig")) {
            try {
                return fn.apply(
                        connection, data
                );
            } catch (UnacceptableValue e) {
                System.out.println(e.getMessage());
                throw new SQLException(e);
            } catch (SQLException e) {
                System.out.println(e.getMessage() + fn + data);
                throw new SQLException(e);
            }
        }
    }
}
