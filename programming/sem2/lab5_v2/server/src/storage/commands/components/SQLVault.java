package server.storage.commands.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLVault {
    public void shouldGetJdbcConnection() throws SQLException {
        try(Connection connection = DriverManager.getConnection(
                "jdbc:postgres://se.ifmo.ru:3306/db_name",
                "user", "password")) {
            System.out.println(connection.isValid(1));
            System.out.println(connection.isClosed());
        }
    }
}
