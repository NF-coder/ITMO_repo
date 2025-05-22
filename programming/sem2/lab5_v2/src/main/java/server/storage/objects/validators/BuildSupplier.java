package server.storage.objects.validators;

import server.storage.commands.commands.argsBuilder.ArgsBuilderV2;
import server.storage.objects.enums.Climate;
import server.storage.objects.enums.Government;
import server.storage.objects.enums.StandardOfLiving;

public class BuildSupplier {
    public static ArgsBuilderV2 CityBuild(ArgsBuilderV2 builder) {
        return builder.putString("name")
                .putInteger("area", 0L, null)
                .putInteger("population", 0L, null)
                .putEnum("climate", Climate.class)
                .putEnum("government", Government.class)
                .putEnum("standardOfLiving", StandardOfLiving.class)
                .putReal("x")
                .putReal("y")
                .putString("govName")
                .putInteger("age")
                .putInteger("height")
                .putInteger("metersAboveSeaLevel")
                .putDate("birthday");
    }
}
