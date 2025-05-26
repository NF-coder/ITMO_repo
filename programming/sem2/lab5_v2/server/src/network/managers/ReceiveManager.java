package network.managers;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import network.container.NetworkContainer;
import network.drivers.NetDriverReceive;
import network.serializers.INetworkDeserializer;
import shared.objects.NetworkRequestDTO;

/**
 * Менеджер, управляющий получением данных
 * @param <T> тип получаемых данных
 */
public class ReceiveManager <T>{
    private final NetDriverReceive<T> driver;
    private final INetworkDeserializer serializer;

    public ReceiveManager(NetDriverReceive<T> driver, INetworkDeserializer serializer) {
        this.driver = driver;
        this.serializer = serializer;
    }

    /**
     * Пайплайн получения данных
     * @return полученные данные
     */
    public CompletableFuture<NetworkContainer<NetworkRequestDTO, T>> call() {
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        return this.driver.receive();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).thenApply(
                res -> {
                    try {
                        return new NetworkContainer<>(
                                res.connInfo(),
                                this.serializer.apply(
                                        res.data()
                                ));
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

    }
}