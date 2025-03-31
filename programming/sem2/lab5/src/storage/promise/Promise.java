package storage.promise;

import java.util.HashMap;

public record Promise(
        String opName,
        Enum<PromiseStatus> status,
        HashMap<String,String> args,
        HashMap<String,String> result
){}