package objects.parsers.InvokersParsers.ObjectsParsers;

import core.Engine;
import objects.enums.EnumInterface;
import textWorkers.invokers.IInvoker;


public class EnumsParser{
    public static <E extends Enum<E> & EnumInterface> E parse(Class<E> enumObj, String caption, boolean isNullable){
        IInvoker invoker = Engine.getActiveInvoker();

        String AVAILABLE_CONSTANTS = "";
        for (E obj : enumObj.getEnumConstants()) {
            AVAILABLE_CONSTANTS = AVAILABLE_CONSTANTS + ", " + obj.toString();
        }
        AVAILABLE_CONSTANTS = AVAILABLE_CONSTANTS.substring(2);

        String value = invoker.parseFieldInput("Введите " + caption + ". " +
                "Доступны значения " + AVAILABLE_CONSTANTS
        );

        if (isNullable && value.isEmpty()){
            return null;
        }

        return Enum.valueOf(enumObj, value);
    }
}
