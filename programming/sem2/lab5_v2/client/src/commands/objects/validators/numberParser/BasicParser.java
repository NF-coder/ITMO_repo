package commands.objects.validators.numberParser;

import commands.exceptions.UnacceptableValue;

public class BasicParser {
    public static <T> T convert(String value, CheckedBasicParser<String, T> validator) throws UnacceptableValue {
        try {
            return validator.accept(value);
        }
        catch (NumberFormatException e){
            throw new UnacceptableValue("Введённое значение не может быть конвертировано в заданный числовой формат!");
        }
        catch (IllegalArgumentException e){
            throw new UnacceptableValue("Введённое значение недопустимо!");
        }
    }
}
