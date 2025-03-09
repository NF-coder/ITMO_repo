package objects.validators;


import exceptions.UnacceptableValue;

public class CityValidators {
    public static String validateName(String value) throws UnacceptableValue {
        if (value == null || value.isEmpty()){
            throw new UnacceptableValue("Имя города должно быть указано!");
        }
        return value;
    }
    public static double validateArea(double value) throws UnacceptableValue{
        if (value <= 0 ){
            throw new UnacceptableValue("Площадь города должна быть строго больше 0!");
        }
        return value;
    }
    public static long validatePopulation(long value) throws UnacceptableValue{
        if (value <= 0 ){
            throw new UnacceptableValue("Население города должно быть строго больше 0!");
        }
        return value;
    }
}
