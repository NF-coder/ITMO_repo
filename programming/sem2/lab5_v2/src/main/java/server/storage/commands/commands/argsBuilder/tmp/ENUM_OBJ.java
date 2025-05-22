package server.storage.commands.commands.argsBuilder.tmp;

import server.storage.objects.enums.EnumInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public record ENUM_OBJ(Class<? extends EnumInterface> enumClass){
    public HashMap<String, String> toHmap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("options", Arrays.stream(enumClass.getEnumConstants())
                .map(Object::toString)
                .collect(Collectors.joining(" "))
        );
        return map;
    }
}
