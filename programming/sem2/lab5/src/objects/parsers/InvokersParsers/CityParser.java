package objects.parsers.InvokersParsers;

import objects.enums.Climate;
import objects.enums.Government;
import objects.enums.StandardOfLiving;
import objects.parsers.InvokersParsers.ObjectsParsers.EnumsParser;
import objects.parsers.InvokersParsers.ObjectsParsers.IParser;
import objects.parsers.InvokersParsers.ObjectsParsers.NonPrimitiveTypesParser;

public class CityParser {
    public static Climate getClimate(){
        return NonPrimitiveTypesParser.looped_parse(
                (IParser<Climate>) () -> EnumsParser.parse(Climate.class, "тип климата", false)
        );
    }
    public static Government getGovernment(){
        return NonPrimitiveTypesParser.looped_parse(
                (IParser<Government>) () -> EnumsParser.parse(Government.class, "тип правительства", false)
        );
    }
    public static StandardOfLiving getStandardOfLiving(){
        return NonPrimitiveTypesParser.looped_parse(
                (IParser<StandardOfLiving>) () -> EnumsParser.parse(StandardOfLiving.class, "стандарт качества жизни", true)
        );
    }
}
