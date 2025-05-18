package client.commands.objects.validators;

import client.commands.exceptions.UnacceptableValue;
import client.commands.objects.validators.numberParser.BasicParser;

/**
 * Валидаторы для элементарных полей в enum-е
 */
public class CityValidators {

    public static void validateName(String value) throws UnacceptableValue {
        if (value == null || value.isEmpty()){
            throw new UnacceptableValue("Имя города должно быть указано!");
        }
    }
    public static void validateArea(String value) throws UnacceptableValue{
        double num = BasicParser.convert(value, Double::parseDouble);
        if (num <= 0 ){
            throw new UnacceptableValue("Площадь города должна быть строго больше 0!");
        }
    }
    public static void validatePopulation(String value) throws UnacceptableValue{
        long num = BasicParser.convert(value, Long::parseLong);
        if (num <= 0 ){
            throw new UnacceptableValue("Население города должно быть строго больше 0!");
        }
    }
    public static void validateMetersAboveSeaLevel(String value) throws UnacceptableValue{
        float num = BasicParser.convert(value, Float::parseFloat);
    }
}
