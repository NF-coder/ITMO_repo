package client.network.drivers;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;

/**
 * Интерфейс для взаимодействия по сети
 */
public interface INetworkDriver {
    /**
     * Инициализация драйвера
     * @throws SocketException
     * @throws IOException
     */
    public void init() throws SocketException, IOException;

    /**
     * Отправка данных
     * @param data массив байтов
     * @throws IOException
     */
    void send(byte[] data) throws IOException;

    /**
     * Получение данных
     * @return массив полученных байтов
     * @throws IOException
     */
    byte[] receive() throws IOException;
}
