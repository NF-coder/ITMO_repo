package server.storage.commands.commands.argsBuilder.tmp;

import java.util.HashMap;

public record INTEGER_OBJ(Long min, Long max) {
    public HashMap<String, String> toHmap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("min", min.toString());
        map.put("max", max.toString());
        return map;
    }
}
