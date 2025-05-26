package storage.commands.components.sql.operations;

import storage.commands.components.sql.operations.DTOs.UserDTO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersTable {
    private String getfprint(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] result = md.digest(string.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : result) hexString.append(String.format("%02x", b));
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Void createTable(Connection connection, Void data) throws SQLException {
        String SQL = "CREATE TABLE IF NOT EXISTS USERS (" +
                "LOGIN TEXT PRIMARY KEY, " +
                "PASSWORD VARCHAR(64) NOT NULL " +
                ")";
        connection.createStatement().executeUpdate(SQL);
        return null;
    }
    public Void deleteTable(Connection connection, Void data) throws SQLException {
        String SQL = "DROP TABLE IF EXISTS USERS;";
        connection.createStatement().executeUpdate(SQL);
        return null;
    }
    public Void addUser(Connection connection, UserDTO data) throws SQLException {
        String SQL = "INSERT INTO USERS VALUES (" +
                 "'" + data.username() + "', '" + getfprint(data.password()) + "'" +
                ");";
        connection.createStatement().executeUpdate(SQL);
        return null;
    }
    public boolean check(Connection connection, UserDTO data) throws SQLException {
        System.out.println("Checking user " + data);

        String SQL = "SELECT * FROM USERS WHERE LOGIN = '" + data.username() + "';";
        ResultSet result = connection.createStatement().executeQuery(SQL);

        System.out.println(result);
        System.out.println(data.password());
        System.out.println(getfprint(data.password()));
        System.out.println(result.next());

        return result.getString("password")
                .equals(getfprint(data.password()));
    }
}
