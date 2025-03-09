package commands.parsers;

import commands.converters.Converters;
import exceptions.UnacceptableValue;
import objects.Coordinates;
import objects.Human;
import textWorkers.Invokers.CLInvoker;
import textWorkers.Invoker;

public class AdditionalParsers {
    public static Coordinates parseCoordinates() throws UnacceptableValue {
        CLInvoker invoker = new CLInvoker();
        String x = invoker.parseFieldInput("Введите координату города по широте");
        String y = invoker.parseFieldInput("Введите координату города по долготе");

        return new Coordinates(
                Converters.StringToPrimitiveDouble(x),
                Converters.StringToFloat(y)
        );
    }
    public static Human parseHuman() throws UnacceptableValue {
        CLInvoker invoker = new CLInvoker();

        String name = invoker.parseFieldInput("Введите имя мэра");
        String age = invoker.parseFieldInput("Введите возраст мэра");
        String hieght = invoker.parseFieldInput("Введите рост мэра");
        String birthday = invoker.parseFieldInput("Введите дату рождения мэра в формате DD.MM.YYYY");

        return new Human(
                name,
                Converters.StringToPrimitiveLong(age),
                Converters.StringToPrimitiveDouble(hieght),
                Converters.DateStringToLocalDateTime(birthday)
        );
    }
}
