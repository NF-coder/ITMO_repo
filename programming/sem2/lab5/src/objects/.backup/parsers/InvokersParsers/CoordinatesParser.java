package objects.parsers.InvokersParsers;

import core.Engine;
import objects.converters.Converters;
import objects.parsers.InvokersParsers.ObjectsParsers.IParser;
import objects.parsers.InvokersParsers.ObjectsParsers.NonPrimitiveTypesParser;
import objects.validators.CoordinatesValidators;
import textWorkers.invokers.IInvoker;

public class CoordinatesParser {
    public static double getX(){
        IInvoker invoker = Engine.getActiveInvoker();
        while (true){
            try {
                return CoordinatesValidators.validateCoordinate(
                        Converters.StringToPrimitiveDouble(
                                invoker.parseFieldInput("Введите координату города по широте")
                        )
                );
            }
            catch (Exception err){
                System.out.println("Введите значение повторно");
            }
        }
    }
    public static Float getY(){
        return NonPrimitiveTypesParser.looped_parse(
                (IParser<Float>) () -> CoordinatesValidators.validateCoordinate(
                        Converters.StringToFloat(
                                IParser.invoker.parseFieldInput("Введите координату города по долготе")
                        )
                )
        );
    }
}
