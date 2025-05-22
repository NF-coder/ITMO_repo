package server;

import server.core.Engine;
import server.network.drivers.implementations.TCPDriver;
import server.network.serializers.implementations.BinarySerializer;
import server.storage.collection.drivers.implementations.DequeDriver;

import java.util.concurrent.Executors;

public class ServerCycle implements Runnable {
    public void run(){
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
