package server.storage.commands.commands.argsBuilder.tmp;

import java.util.HashMap;

public record REAL_OBJ(Double min, Double max){
    public HashMap<String, String> toHmap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("min", min.toString());
        map.put("max", max.toString());
        return map;
    }
}
