package storage.commands.commands.implementations;

import org.json.JSONArray;
import org.json.JSONObject;
import storage.commands.commands.Command;
import java.util.stream.Collectors;

public class FilterStartsWithName extends Command {
    public FilterStartsWithName() {
        super("filter_starts_with_name");
    }
    public JSONObject call(){
        return new JSONObject().put(
                "array",
                new JSONArray().put(
                        this.driver.getCollection().stream()
                                .filter(elem -> elem.getName().indexOf(this.args.get("name_beginning")) == 0)
                                .map(Object::toString)
            )
        );
    }
}
