package server.network.managers;

import server.network.container.NetworkContainer;
import server.network.drivers.NetDriverSend;
import server.network.serializers.INetworkSerializer;
import shared.objects.NetworkResponseDTO;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Менеджер, управляющий отправкой данных
 * @param <T> тип отправляемых данных
 */
public class SendManager<T> {
    NetDriverSend<T> driver;
    INetworkSerializer serializer;

    public SendManager(NetDriverSend<T> driver, INetworkSerializer serializer) {
        this.driver = driver;
        this.serializer = serializer;
    }

    /**
     * Пайплайн отправки данных
     * @param elem Конейнер с отправляемыми данными
     * @return ЦЕНОК
     */
    public CompletableFuture<Void> call(NetworkContainer<NetworkResponseDTO, T> elem){
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        return this.serializer.apply(
                                elem.data()
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
        ).thenAccept(
                res -> {
                    try {
                        this.driver.send(
                                new NetworkContainer<> (
                                        elem.connInfo(),
                                        res
                                )
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
