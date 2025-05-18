package server.network.container;

import java.net.SocketAddress;

/**
 * DTO для хранения информации для отправки ответа клиенту и данных, полученных из него
 * @param connInfo информация о соединении
 * @param data блок с основной информацией
 * @param <T> тип основной информации
 * @param <R> тип данных о соединении
 */
public record NetworkContainer<T, R> (R connInfo, T data) {}
