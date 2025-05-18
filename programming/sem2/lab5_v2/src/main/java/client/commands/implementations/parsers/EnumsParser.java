package client.commands.implementations.parsers;

import client.commands.exceptions.UnacceptableValue;
import client.commands.objects.enums.EnumInterface;
import client.textWorkers.Invokers.CLInvoker;
import client.textWorkers.Invokers.IInvoker;

/**
 * Парсер для enum-oв, автоматически создающий текст приглашение
 */
public class EnumsParser {
    /**
     *
     * @param enumObj enum
     * @param caption название enum-а
     * @param invoker поставщик строк
     * @return значение enuma
     * @param <E> тип enum-а
     */
    public static <E extends Enum<E> & EnumInterface> E parse(Class<E> enumObj, String caption, IInvoker invoker) throws InterruptedException{
        StringBuilder AVAILABLE_CONSTANTS = new StringBuilder();
        for (E obj : enumObj.getEnumConstants()) AVAILABLE_CONSTANTS.append(", ").append(obj.toString());
        AVAILABLE_CONSTANTS = new StringBuilder(AVAILABLE_CONSTANTS.substring(2));

        String value = LoopedParse.parse(
                "Введите " + caption + ". " + "Доступны значения " + AVAILABLE_CONSTANTS,
                invoker,
                (str) -> {
                    try {
                        Enum.valueOf(enumObj, str);
                    } catch (IllegalArgumentException e) {
                        throw new UnacceptableValue("Введённое значение недопустимо!");
                    }
                }
        );

        return Enum.valueOf(enumObj, value);
    }
}
