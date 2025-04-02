package objects.validators;

import exceptions.UnacceptableValue;

public class HumanValidators {
    public static String validateName(String value) throws UnacceptableValue{
        if (value == null || value.isEmpty()){
            throw new UnacceptableValue("Имя мэра должно быть указано!");
        }
        return value;
    }
    public static long validateAge(long value) throws UnacceptableValue{
        if (value <= 0 ){
            throw new UnacceptableValue("Возраст мэра должен быть строго больше 0!");
        }
        return value;
    }
    public static double validateHeight(double value) throws UnacceptableValue{
        if (value <= 0 ){
            throw new UnacceptableValue("Рост мэра должен быть строго больше 0!");
        }
        return value;
    }
}
