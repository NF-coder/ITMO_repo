package server.network.serializers;

import shared.objects.NetworkRequestDTO;
import shared.objects.NetworkResponseDTO;

import java.io.IOException;

/**
 * Класс для сериализации/десереализации данных
 */
public interface INetworkSerializers {
    /**
     * Сериализация данных
     * @param data данные
     * @return массив байтов для передачи
     * @throws IOException если не удалось сериализовать
     */
    byte[] serialize(NetworkResponseDTO data) throws IOException;

    /**
     * Десериализация данных
     * @param data массив полученных байтов
     * @return данные
     * @throws IOException если не удалось десериаализовать
     * @throws ClassNotFoundException если не удалось привести данные к нужному типу
     */
    NetworkRequestDTO deserialize(byte[] data) throws IOException, ClassNotFoundException;
}
