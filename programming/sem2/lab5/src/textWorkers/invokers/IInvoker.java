package textWorkers.invokers;

import core.Engine;

public interface IInvoker {
    /**
     * Метод, используемый для получения дополнительных аргументов
     * @param entryText Строка-команда
     * @return String полученное значение
     */
    public String parseFieldInput(String entryText);

    /**
     * Метод, запускающий основной цикл работы
     */
    public void mainCycle(Engine engine);
}
