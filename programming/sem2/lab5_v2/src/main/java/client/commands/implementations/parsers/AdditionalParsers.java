package client.commands.implementations.parsers;

import client.commands.objects.validators.CoordinatesValidators;
import client.commands.objects.validators.HumanValidators;
import client.textWorkers.Invokers.CLInvoker;
import client.commands.exceptions.UnacceptableValue;

import java.util.HashMap;

public class AdditionalParsers {
    public static HashMap<String,String> parseCoordinates(HashMap<String,String> args) throws UnacceptableValue {
        CLInvoker invoker = new CLInvoker();

        String x = invoker.parseFieldInput("Введите координату города по широте");
        String y = invoker.parseFieldInput("Введите координату города по долготе");

        CoordinatesValidators.validateCoordinateX(x);
        CoordinatesValidators.validateCoordinateY(y);

        args.put("x",x);
        args.put("y",y);

        return args;
    }
    public static HashMap<String,String> parseHuman(HashMap<String,String> args) throws UnacceptableValue {
        CLInvoker invoker = new CLInvoker();


        String name = invoker.parseFieldInput("Введите имя мэра");
        HumanValidators.validateName(name);



        String age = invoker.parseFieldInput("Введите возраст мэра");
        HumanValidators.validateAge(age);

        String height = invoker.parseFieldInput("Введите рост мэра");
        HumanValidators.validateHeight(height);

        String birthday = invoker.parseFieldInput("Введите дату рождения мэра в формате DD.MM.YYYY");
        HumanValidators.DateStringToLocalDateTime(birthday);

        args.put("govName",name);
        args.put("age",age);
        args.put("height",height);
        args.put("birthday",birthday);

        return args;
    }
}
