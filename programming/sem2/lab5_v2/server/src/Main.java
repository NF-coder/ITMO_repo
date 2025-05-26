import core.Engine;
import network.drivers.implementations.TCPDriver;
import network.serializers.implementations.BinarySerializer;
import storage.collection.drivers.implementations.DequeDriver;
import storage.commands.components.sql.SQLVault;
import storage.commands.components.sql.StructWithSQLDriverDecorator;
import storage.commands.components.sql.operations.CollectionTable;
import storage.commands.components.sql.operations.UsersTable;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        SQLVault vault = new SQLVault();
        try {
            vault.connectionExecutor(new CollectionTable()::deleteTable, null);
            vault.connectionExecutor(new UsersTable()::deleteTable, null);
            vault.connectionExecutor(new UsersTable()::createTable, null);
            vault.connectionExecutor(new CollectionTable()::createTable, null);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Engine engine = new Engine(
                new TCPDriver(4056),
                Executors.newFixedThreadPool(4),
                Executors.newFixedThreadPool(1),
                Executors.newFixedThreadPool(3),
                new BinarySerializer(),
                new StructWithSQLDriverDecorator(new DequeDriver())
        );
    }
}
