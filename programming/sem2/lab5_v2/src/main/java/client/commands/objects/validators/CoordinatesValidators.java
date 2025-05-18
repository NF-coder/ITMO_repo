package client.commands.objects.validators;

import client.commands.exceptions.UnacceptableValue;
import client.commands.objects.validators.numberParser.BasicParser;

public class CoordinatesValidators {
    public static void validateCoordinateX(String value) throws UnacceptableValue{
        double num = BasicParser.convert(value, Double::parseDouble);
        if (num > 477){
            throw new UnacceptableValue("Координата города не должна превышать 477!");
        }
    }
    public static void validateCoordinateY(String value)throws UnacceptableValue{
        float num = BasicParser.convert(value, Float::parseFloat);
        if (num > 477){
            throw new UnacceptableValue("Координата города не должна превышать 477!");
        }
    }
}
