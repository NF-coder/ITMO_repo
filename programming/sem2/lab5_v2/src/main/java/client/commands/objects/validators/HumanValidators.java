package client.commands.objects.validators;

import client.commands.exceptions.UnacceptableValue;
import client.commands.objects.validators.np.BasicParser;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class HumanValidators {
    public static void validateName(String value) throws UnacceptableValue {
        if (value == null || value.isEmpty()){
            throw new UnacceptableValue("Имя мэра должно быть указано!");
        }
    }
    public static void validateAge(String value) throws UnacceptableValue{
        long num = BasicParser.convert(value, Long::parseLong);
        if (num <= 0 ){
            throw new UnacceptableValue("Возраст мэра должен быть строго больше 0!");
        }
    }
    public static void validateHeight(String value) throws UnacceptableValue{
        double num = BasicParser.convert(value, Double::parseDouble);
        if (num <= 0 ){
            throw new UnacceptableValue("Рост мэра должен быть строго больше 0!");
        }
    }
    public static void DateStringToLocalDateTime(String value) throws UnacceptableValue {
        DateTimeFormatter DTF = new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.uuuu")
                //.optionalStart()
                //.appendPattern(" HH:mm")
                //.optionalEnd()
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .toFormatter();
        try {
            LocalDateTime.parse(value, DTF);
        }
        catch (DateTimeException err){
            throw new UnacceptableValue("Проверьте правильность заполнения даты!");
        }
    }
}
