package client.textWorkers.Invokers;

import client.core.Engine;

/**
 * Интерфейс, отвечающий за получение вводной информации
 */
public interface IInvoker {
    /**
     * Получение данных для получения сложных объектов
     * @param entryText текст-приглашение
     * @return введённые пользователем данные
     */
    public String parseFieldInput(String entryText);

    /**
     * Получение основной строки команды
     * @param engine движок обработчика
     */
    public void mainCycle(Engine engine);
}
