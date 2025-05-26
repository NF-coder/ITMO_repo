package storage.commands.commands.implementations;

import storage.commands.commands.Command;
import storage.objects.City;

public class AvgOfMetersAboveSea extends Command {
    public AvgOfMetersAboveSea() {
        super("average_of_meters_above_sea_level");
    }
    public String call(){
        float result = (float) driver.getCollection().stream()
                .mapToDouble(City::getMetersAboveSeaLevel)
                .average()
                .orElse(Double.NaN);
        return Float.toString(result);
    }
}
