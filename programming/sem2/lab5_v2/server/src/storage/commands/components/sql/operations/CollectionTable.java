package storage.commands.components.sql.operations;

import storage.commands.components.sql.operations.DTOs.DataWithLoginDTO;
import storage.commands.components.sql.operations.utils.SQLInsertBuilder;
import storage.objects.City;

import java.sql.Connection;
import java.sql.SQLException;

public class CollectionTable {
    public Void createTable(Connection connection, Void data) throws SQLException {
        String SQL = "CREATE TABLE IF NOT EXISTS COLLECTION (" +
                "ID SERIAL PRIMARY KEY, " +
                "CREATION_DATE TEXT NOT NULL, " +
                "NAME TEXT NOT NULL, " +
                "X REAL NOT NULL, " +
                "Y REAL NOT NULL, " +
                "AREA REAL NOT NULL, " +
                "POPULATION INTEGER NOT NULL, " +
                "METERS_ABOVE_SEA_LEVEL REAL NOT NULL, " +
                "CLIMATE VARCHAR(30) NOT NULL, " +
                "GOVERNMENT VARCHAR(30) NOT NULL, " +
                "STANDARD_OF_LIVING VARCHAR(30) NOT NULL, " +
                "GOVERNOR_NAME TEXT NOT NULL, " +
                "GOVERNOR_AGE INTEGER NOT NULL, " +
                "GOVERNOR_HEIGHT REAL NOT NULL, " +
                "GOVERNOR_BIRTHDAY TEXT NOT NULL, " +
                "CREATOR_ID TEXT NOT NULL REFERENCES USERS(LOGIN)" +
                ")";
        connection.createStatement().executeUpdate(SQL);
        return null;
    }
    public Void deleteTable(Connection connection, Void data) throws SQLException {
        String SQL = "DROP TABLE IF EXISTS COLLECTION;";
        connection.createStatement().executeUpdate(SQL);
        return null;
    }
    public Void addCity(Connection connection, DataWithLoginDTO<City> data) throws SQLException {
        String SQL = new SQLInsertBuilder("COLLECTION")
                .addQuoted(data.data().getCreationDate().toString())
                .addQuoted(data.data().getName())
                .addRaw(data.data().getCoordinates().getX())
                .addRaw(data.data().getCoordinates().getY())
                .addRaw(data.data().getArea())
                .addRaw(data.data().getPopulation())
                .addRaw(data.data().getMetersAboveSeaLevel())
                .addQuoted(data.data().getClimate().toString())
                .addQuoted(data.data().getGovernment().toString())
                .addQuoted(data.data().getStandardOfLiving().toString())
                .addQuoted(data.data().getGovernment().name())
                .addRaw(data.data().getGovernor().getAge())
                .addRaw(data.data().getGovernor().getHeight())
                .addQuoted(data.data().getGovernor().getBirthday().toString())
                .addQuoted(data.login())
                .build();

        connection.createStatement().executeUpdate(SQL);
        return null;
    }
    public Void deleteById(Connection connection, long id) throws SQLException {
        String SQL = "DELETE FROM COLLECTION WHERE ID=" + id + ";";
        connection.createStatement().executeUpdate(SQL);
        return null;
    }
}
