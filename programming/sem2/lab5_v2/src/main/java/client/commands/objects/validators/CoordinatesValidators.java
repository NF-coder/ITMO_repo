package client.commands.objects.validators;

import client.commands.exceptions.UnacceptableValue;

public class CoordinatesValidators {
    public static void validateCoordinateX(String value) throws UnacceptableValue{
        double num = Double.parseDouble(value);
        if (num > 477){
            throw new UnacceptableValue("Координата города не должна превышать 477!");
        }
    }
    public static void validateCoordinateY(String value)throws UnacceptableValue{
        float num = Float.parseFloat(value);
        if (num > 477){
            throw new UnacceptableValue("Координата города не должна превышать 477!");
        }
    }
}
