package storage.commands.components.sql;

import org.json.JSONObject;
import storage.collection.drivers.IStructDriver;
import storage.commands.components.sql.operations.CollectionTable;
import storage.commands.components.sql.operations.DTOs.DataWithLoginDTO;
import storage.objects.City;
import storage.objects.exceptions.ElementNotFound;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayDeque;

public class StructWithSQLDriverDecorator implements IStructDriver {
    private final IStructDriver structDriver;

    public StructWithSQLDriverDecorator(IStructDriver structDriver) {
        this.structDriver = structDriver;
        try {
            for (City city : SQLVault.connectionExecutor(new CollectionTable()::getAll, null))
                this.structDriver.add(city);
        } catch (SQLException ignored) {}
    }

    public City getById(Long id) throws ElementNotFound {
        return structDriver.getById(id);
    }
    public ArrayDeque<City> getCollection(){
        return structDriver.getCollection();
    }

    public void add(City data) {
        try {
            data.setCreationDate(LocalDateTime.now());

            long id = SQLVault.connectionExecutor(
                    new CollectionTable()::addCity,
                    new DataWithLoginDTO<>(data, data.getCreator())
            );
            data.setId(id);

            structDriver.add(data);;
        } catch (SQLException e) {
            System.out.println("Error while adding city" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void removeById(Long id){
        try {

            SQLVault.connectionExecutor(
                    new CollectionTable()::deleteById,
                    id
            );

            structDriver.removeById(id);
        } catch (SQLException e) {
            System.out.println("Error while removing id " + id + "\n" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void removeFirst(){
        /*try {
            SQLVault.connectionExecutor(
                    new CollectionTable()::removeFirst,
                    null
            );
            driver.removeFirst();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

    public void clearCollection(){
        try {
            SQLVault.connectionExecutor(
                    new CollectionTable()::clearTable,
                    null
            );
            structDriver.clearCollection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "SQLDecorator+" + this.structDriver.toString();
    }

    @Override
    public JSONObject getJSON(){
        JSONObject jo = this.structDriver.getJSON();
        return jo.put("driverName", "SQLDecorator+"+jo.getString("driverName"));
    }
}
