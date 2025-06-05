package storage.commands.commands.implementations;

import org.json.JSONObject;
import storage.commands.commands.Command;
import storage.objects.City;

public class AvgOfMetersAboveSea extends Command {
    public AvgOfMetersAboveSea() {
        super("average_of_meters_above_sea_level");
    }
    public JSONObject call(){
        return new JSONObject().put(
                "avg_meters",
                driver.getCollection().stream()
                        .mapToDouble(City::getMetersAboveSeaLevel)
                        .average()
                        .orElse(Double.NaN)
        );
    }
}
