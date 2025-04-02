package objects.parsers.InvokersParsers;

import core.Engine;
import objects.converters.Converters;
import objects.parsers.InvokersParsers.ObjectsParsers.IParser;
import objects.parsers.InvokersParsers.ObjectsParsers.NonPrimitiveTypesParser;
import objects.validators.HumanValidators;
import textWorkers.invokers.IInvoker;

import java.time.LocalDateTime;

public class HumanParser {
    public static String getName() {
        return NonPrimitiveTypesParser.looped_parse(
                (IParser<String>) () -> HumanValidators.validateName(
                        IParser.invoker.parseFieldInput("Введите имя мэра")
                )
        );
    }
    public static long getAge() {
        IInvoker invoker = Engine.getActiveInvoker();
        while (true) {
            try {
                return HumanValidators.validateAge(
                        Converters.StringToPrimitiveLong(
                                invoker.parseFieldInput("Введите возраст мэра")
                        )
                );
            } catch (Exception err) {
                System.out.println("Введите значение повторно");
            }
        }
    }
    public static double getHeight() {
        IInvoker invoker = Engine.getActiveInvoker();
        while (true) {
            try {
                return HumanValidators.validateHeight(
                        Converters.StringToPrimitiveDouble(
                                invoker.parseFieldInput("Введите рост мэра")
                        )
                );
            } catch (Exception err) {
                System.out.println("Введите значение повторно");
            }
        }
    }
    public static LocalDateTime getBirthDate() {
        return  NonPrimitiveTypesParser.looped_parse(
                (IParser<LocalDateTime>) () -> Converters.DateStringToLocalDateTime(
                        IParser.invoker.parseFieldInput("Введите дату рождения мэра в формате DD.MM.YYYY")
                )
        );
    }
}