package storage.commands.commands.implementations;

import org.json.JSONArray;
import org.json.JSONObject;
import storage.commands.commands.Command;
import storage.objects.City;

import java.util.Optional;
import java.util.stream.Collectors;

public class Show extends Command {
    public Show() {
        super("show");
    }
    public JSONObject call(){
        JSONArray jsonArray = this.driver.getCollection().stream()
                .map(City::toJSON)
                .collect(JSONArray::new, JSONArray::put, JSONArray::putAll);
        return new JSONObject().put("array", jsonArray);
    }
}
