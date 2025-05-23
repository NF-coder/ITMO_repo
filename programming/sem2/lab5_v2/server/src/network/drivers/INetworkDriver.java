package server.network.drivers;

import server.network.container.NetworkContainer;

import java.io.IOException;
import java.net.SocketException;

/**
 * Интерфейс для сетевых драйверов
 * @param <T> тип данных, которые мы хотим принимать/отправлять
 */
public interface INetworkDriver<T>{
    /**
     * Инициализация драйвера подключения
     * @throws IOException исключения, связанные с невозможностью инициализации драйвера
     */
    public void init() throws IOException;

    /**
     * Отправка данных
     * @param data данные
     * @throws IOException Исключения, связанные с проблемами отправки
     */
    public void send(NetworkContainer<byte[], T> data) throws IOException;
    /**
     * Получение данных
     * @return полученные данные
     * @throws IOException Исключения, связанные с проблемами получения
     */
    public NetworkContainer<byte[], T> receive() throws IOException;
}
