package storage.commands.components.sql.operations;

import storage.commands.components.sql.operations.DTOs.CityIdAndCreatorDTO;
import storage.commands.components.sql.operations.DTOs.DataWithLoginDTO;
import storage.commands.components.sql.operations.utils.SQLInsertBuilder;
import storage.objects.City;
import storage.objects.Coordinates;
import storage.objects.Human;
import storage.objects.exceptions.UnacceptableValue;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayDeque;

public class CollectionTable {
    private final String[] columns = {
          "CREATION_DATE", "NAME", "X", "Y", "AREA", "POPULATION", "METERS_ABOVE_SEA_LEVEL", "CLIMATE",
            "GOVERNMENT", "STANDARD_OF_LIVING", "GOVERNOR_NAME", "GOVERNOR_AGE", "GOVERNOR_HEIGHT",
            "GOVERNOR_BIRTHDAY", "CREATOR_ID"
    };
    public Void createTable(Connection connection, Void data) throws SQLException {
        String SQL = "CREATE TABLE IF NOT EXISTS COLLECTION (" +
                "ID SERIAL PRIMARY KEY, " +
                "CREATION_DATE TIMESTAMP NOT NULL, " +
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
                "GOVERNOR_BIRTHDAY TIMESTAMP NOT NULL, " +
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

    public Long addCity(Connection connection, DataWithLoginDTO<City> data) throws SQLException {
        String SQL = new SQLInsertBuilder("COLLECTION", columns)
                .addQuoted(
                        data.data().getCreationDate().toString()
                )
                .addQuoted(data.data().getName())
                .addRaw(data.data().getCoordinates().getX())
                .addRaw(data.data().getCoordinates().getY())
                .addRaw(data.data().getArea())
                .addRaw(data.data().getPopulation())
                .addRaw(data.data().getMetersAboveSeaLevel())
                .addQuoted(data.data().getClimate().toString())
                .addQuoted(data.data().getGovernment().toString())
                .addQuoted(data.data().getStandardOfLiving().toString())
                .addQuoted(data.data().getGovernor().getName())
                .addRaw(data.data().getGovernor().getAge())
                .addRaw(data.data().getGovernor().getHeight())
                .addQuoted(
                        data.data().getGovernor().getBirthday().toString()
                )
                .addQuoted(data.login())
                .build();
        try (PreparedStatement result = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            result.executeUpdate();
            try (ResultSet generatedKeys = result.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Failed to get generated ID");
                }
            }
        }
    }
    public Void deleteById(Connection connection, long id) throws SQLException {
        String SQL = "DELETE FROM COLLECTION WHERE ID=" + id + ";";
        connection.createStatement().executeUpdate(SQL);
        return null;
    }
    public Void clearTable(Connection connection, Void data) throws SQLException {
        String SQL = "TRUNCATE COLLECTION;";
        connection.createStatement().executeUpdate(SQL);
        return null;
    }
    /*public Void removeFirst(Connection connection, Void data) throws SQLException {
        String SQL = "DELETE FROM COLLECTION " +
                "WHERE ID = (SELECT 1 ORDER BY CREATION_DATE)";
        connection.createStatement().executeUpdate(SQL);
        return null;
    }*/
    public CityIdAndCreatorDTO getFirstElemInfo(Connection connection, Void data) throws SQLException {
        String SQL = "SELECT * FROM COLLECTION " +
                "ORDER BY CREATION_DATE LIMIT 1;";
        ResultSet rs = connection.createStatement().executeQuery(SQL);
        rs.next();
        return new CityIdAndCreatorDTO(
                rs.getLong(1),
                rs.getString("creator_id")
        );
    }
    public CityIdAndCreatorDTO getElemInfoById(Connection connection, long id) throws SQLException {
        String SQL = "SELECT * FROM COLLECTION WHERE ID=" + id + ";";
        ResultSet rs = connection.createStatement().executeQuery(SQL);
        rs.next();
        return new CityIdAndCreatorDTO(
                rs.getLong("ID"),
                rs.getString("CREATOR_ID")
        );
    }
    public ArrayDeque<City> getAll(Connection connection, Void data) throws SQLException, UnacceptableValue {
        String SQL = "SELECT * FROM COLLECTION;";
        ResultSet rs = connection.createStatement().executeQuery(SQL);

        ArrayDeque<City> cities = new ArrayDeque<>();
        while (rs.next()) {
            City city = new City();

            city.setId(rs.getLong("ID"));
            city.setCreationDate(
                    rs.getTimestamp("CREATION_DATE").toLocalDateTime()
            );
            city.setName(rs.getString("NAME"));
            city.setCoordinates(new Coordinates(rs.getString("X"), rs.getString("Y")));
            city.setArea(rs.getString("AREA"));
            city.setPopulation(rs.getString("POPULATION"));
            city.setMetersAboveSeaLevel(rs.getString("METERS_ABOVE_SEA_LEVEL"));
            city.setClimate(rs.getString("CLIMATE"));
            city.setGovernment(rs.getString("GOVERNMENT"));
            city.setStandardOfLiving(rs.getString("STANDARD_OF_LIVING"));
            city.setGovernor(
                    new Human(
                            rs.getString("GOVERNOR_NAME"),
                            rs.getString("GOVERNOR_AGE"),
                            rs.getString("GOVERNOR_HEIGHT"),
                            rs.getTimestamp("GOVERNOR_BIRTHDAY").toLocalDateTime().format(
                                    new DateTimeFormatterBuilder().appendPattern("dd.MM.uuuu").toFormatter()
                            )
                    )
            );
            city.setCreator(rs.getString("CREATOR_ID"));

            cities.add(city);
        }
        return cities;
    }
}
