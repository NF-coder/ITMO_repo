package server.storage.objects.validators.old;


import server.storage.objects.exceptions.UnacceptableValue;

public class CoordinatesValidators {
    public static double validateCoordinate(double value) throws UnacceptableValue{
        if (value > 477){
            throw new UnacceptableValue("Координата города не должна превышать 477!");
        }
        return value;
    }
    public static Float validateCoordinate(Float value)throws UnacceptableValue{
        if (value > 477){
            throw new UnacceptableValue("Координата города не должна превышать 477!");
        }
        return value;
    }
}
