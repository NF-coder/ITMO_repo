package server.storage.commands.commands.argsBuilder.tmp;

import java.util.HashMap;

public record STRING_OBJ() {
    public HashMap<String, String> toHmap() {
        return new HashMap<>();
    }
}
