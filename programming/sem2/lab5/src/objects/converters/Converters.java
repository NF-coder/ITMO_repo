package objects.converters;

import exceptions.UnacceptableValue;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converters {
    public static double StringToPrimitiveDouble(String value){
        return (double) Double.parseDouble(value);
    }
    public static long StringToPrimitiveLong(String value){
        return (long) Long.parseLong(value);
    }
    public static float StringToPrimitiveFloat(String value){
        return (float) Float.parseFloat(value);
    }
    public static Float StringToFloat(String value){
        return Float.parseFloat(value);
    }
    public static Long StringToLong(String value){
        return Long.parseLong(value);
    }

    public static LocalDateTime DateStringToLocalDateTime(String value) throws UnacceptableValue {
        DateTimeFormatter DTF = new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.uuuu")
                //.optionalStart()
                //.appendPattern(" HH:mm")
                //.optionalEnd()
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .toFormatter();
        try {
            return LocalDateTime.parse(value, DTF);
        }
        catch (DateTimeException err){
            throw new UnacceptableValue("Проверьте правильность заполнения даты!");
        }
    }
}
