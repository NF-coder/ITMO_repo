import core.Engine;
import network.drivers.implementations.TCPDriver;
import network.serializers.implementations.BinarySerializer;
import storage.collection.drivers.IStructDriver;
import storage.collection.drivers.implementations.DequeDriver;
import storage.commands.components.sql.SQLVault;
import storage.commands.components.sql.StructWithSQLDriverDecorator;
import storage.commands.components.sql.operations.CollectionTable;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try {
            //SQLVault.connectionExecutor(new CollectionTable()::deleteTable, null);
            //vault.connectionExecutor(new UsersTable()::deleteTable, null);
            //vault.connectionExecutor(new UsersTable()::createTable, null);
            //SQLVault.connectionExecutor(new CollectionTable()::createTable, null);
            IStructDriver driver = new StructWithSQLDriverDecorator(new DequeDriver());
            Engine engine = new Engine(
                    new TCPDriver(4056),
                    Executors.newSingleThreadExecutor(),
                    Executors.newCachedThreadPool(),
                    Executors.newSingleThreadExecutor(),
                    new BinarySerializer(),
                    driver
            );
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
