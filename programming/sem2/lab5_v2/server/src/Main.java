import server.core.Engine;
import server.network.drivers.implementations.TCPDriver;
import server.network.drivers.implementations.UDPDriver;
import server.network.managers.ReceiveManager;
import server.network.serializers.implementations.BinarySerializer;
import server.storage.collection.drivers.implementations.DequeDriver;
import server.storage.commands.components.SQLVault;

import java.nio.channels.SocketChannel;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        SQLVault vault = new SQLVault();
        try {
            vault.shouldGetJdbcConnection();
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
                new DequeDriver()
        );
    }
}
