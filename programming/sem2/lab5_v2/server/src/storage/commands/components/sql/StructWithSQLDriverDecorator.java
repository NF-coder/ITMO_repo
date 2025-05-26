package storage.commands.components.sql;

import storage.collection.drivers.IStructDriver;
import storage.commands.components.sql.operations.CollectionTable;
import storage.commands.components.sql.operations.DTOs.DataWithLoginDTO;
import storage.objects.City;
import storage.objects.exceptions.ElementNotFound;
import storage.objects.exceptions.UnacceptableValue;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.HashMap;

public class StructWithSQLDriverDecorator implements IStructDriver {
    IStructDriver driver;

    public StructWithSQLDriverDecorator(IStructDriver driver) {
        this.driver = driver;
    }

    public void add(City data) {
        try {
            SQLVault.connectionExecutor(
                    new CollectionTable()::addCity,
                    new DataWithLoginDTO<>(data, data.getCreator())
            );
            data.setId(100L);

            driver.add(data);
        } catch (SQLException e) {
            System.out.println("error on adding city" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public City getById(Long id) throws ElementNotFound {
        return driver.getById(id);
    }

    public void removeById(Long id){
        try {

            SQLVault.connectionExecutor(
                    new CollectionTable()::deleteById,
                    id
            );
            driver.removeById(id);
        } catch (SQLException e) {
            System.out.println("Error while removing id " + id + "\n" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ArrayDeque<City> getCollection(){
        return driver.getCollection();
    }

    public void removeFirst(){
        driver.removeFirst();
    }

    public void clearCollection(){
        driver.clearCollection();
    }
}
