package commands.implementations.parsers;

import commands.objects.validators.CoordinatesValidators;
import commands.objects.validators.HumanValidators;
import commands.exceptions.UnacceptableValue;
import textWorkers.Invokers.IInvoker;

import java.util.HashMap;

/**
 * Парсеры для составных объектов
 */
public class AdditionalParsers {
    public static HashMap<String,String> parseCoordinates(HashMap<String,String> args, IInvoker invoker) throws UnacceptableValue, InterruptedException {
        args.put("x",LoopedParse.parse("Введите координату города по широте", invoker, CoordinatesValidators::validateCoordinateX));
        args.put("y",LoopedParse.parse("Введите координату города по долготе", invoker, CoordinatesValidators::validateCoordinateY));

        return args;
    }
    public static HashMap<String,String> parseHuman(HashMap<String,String> args, IInvoker invoker) throws UnacceptableValue, InterruptedException {
        args.put("govName", LoopedParse.parse("Введите имя мэра", invoker, HumanValidators::validateName));
        args.put("age", LoopedParse.parse("Введите возраст мэра", invoker, HumanValidators::validateAge));
        args.put("height", LoopedParse.parse("Введите рост мэра", invoker, HumanValidators::validateHeight));
        args.put("birthday", LoopedParse.parse("Введите дату рождения мэра в формате DD.MM.YYYY", invoker, HumanValidators::DateStringToLocalDateTime));

        return args;
    }
}
