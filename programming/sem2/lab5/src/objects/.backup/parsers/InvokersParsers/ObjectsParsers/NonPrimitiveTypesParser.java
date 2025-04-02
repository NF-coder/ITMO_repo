package objects.parsers.InvokersParsers.ObjectsParsers;

public class NonPrimitiveTypesParser {
    public static <T> T looped_parse(IParser obj){
        while (true){
            try {
                return (T) obj.run();
            }
            catch (Exception err){
                System.out.println("Введите значение повторно");
            }
        }
    }
}
