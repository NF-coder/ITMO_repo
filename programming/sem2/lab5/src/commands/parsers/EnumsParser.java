package commands.parsers;

import objects.enums.EnumInterface;
import textWorkers.Invokers.CLInvoker;


public class EnumsParser{
    public static <E extends Enum<E> & EnumInterface> E parse(Class<E> enumObj, String caption){
        CLInvoker invoker = new CLInvoker();

        String AVAILABLE_CONSTANTS = "";
        for (E obj : enumObj.getEnumConstants()) {
            AVAILABLE_CONSTANTS = AVAILABLE_CONSTANTS + ", " + obj.toString();
        }
        AVAILABLE_CONSTANTS = AVAILABLE_CONSTANTS.substring(2);

        String value = invoker.parseFieldInput("Введите " + caption + ". " +
                "Доступны значения " + AVAILABLE_CONSTANTS
        );

        return Enum.valueOf(enumObj, value);
    }
}
