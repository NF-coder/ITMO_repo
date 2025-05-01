package server.storage.commands.commands.implementations;

import server.storage.commands.commands.Command;
import server.storage.objects.City;

public class AvgOfMetersAboveSea extends Command {
    public AvgOfMetersAboveSea() {
        super("average_of_meters_above_sea_level");
    }
    public String call(){
        Float result = (float) driver.getCollection().stream()
                .mapToDouble(City::getMetersAboveSeaLevel)
                .average()
                .orElse(Double.NaN);
        return result.toString();
    }
}
