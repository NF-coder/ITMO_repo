package server.storage.commands.commands.argsBuilder;

import server.storage.commands.commands.argsBuilder.tmp.*;
import server.storage.objects.enums.EnumInterface;

import java.util.HashMap;

public class ArgsBuilderV2 {
    private final HashMap<String, REAL_OBJ> REAL_STORAGE = new HashMap<>();
    private final HashMap<String, STRING_OBJ> STRING_STORAGE = new HashMap<>();
    private final HashMap<String, INTEGER_OBJ> INTEGER_STORAGE = new HashMap<>();
    private final HashMap<String, DATE_OBJ> DATE_STORAGE = new HashMap<>();
    private final HashMap<String, ENUM_OBJ> ENUM_STORAGE = new HashMap<>();

    public ArgsBuilderV2 putReal(String name, Double min, Double max) {
        REAL_STORAGE.put(name, new REAL_OBJ(min, max));
        return this;
    }
    public ArgsBuilderV2 putReal(String name) {
        REAL_STORAGE.put(name, new REAL_OBJ(null, null));
        return this;
    }
    public ArgsBuilderV2 putString(String name) {
        STRING_STORAGE.put(name, new STRING_OBJ());
        return this;
    }
    public ArgsBuilderV2 putInteger(String name, Long min, Long max) {
        INTEGER_STORAGE.put(name, new INTEGER_OBJ(min, max));
        return this;
    }
    public ArgsBuilderV2 putInteger(String name) {
        INTEGER_STORAGE.put(name, new INTEGER_OBJ(null, null));
        return this;
    }
    public ArgsBuilderV2 putDate(String name) {
        DATE_STORAGE.put(name, new DATE_OBJ());
        return this;
    }
    public ArgsBuilderV2 putEnum(String name, Class<? extends EnumInterface> enumClass) {
        ENUM_STORAGE.put(name, new ENUM_OBJ(enumClass));
        return this;
    }

    public HashMap<String, HashMap<String, String>> build() {
        HashMap<String, HashMap<String, String>> args = new HashMap<>();

        REAL_STORAGE.forEach((k, v) -> args.put(k, v.toHmap()));
        STRING_STORAGE.forEach((k, v) -> args.put(k, v.toHmap()));
        INTEGER_STORAGE.forEach((k, v) -> args.put(k, v.toHmap()));
        DATE_STORAGE.forEach((k, v) -> args.put(k, v.toHmap()));
        ENUM_STORAGE.forEach((k, v) -> args.put(k, v.toHmap()));

        return args;
    }

    public REAL_OBJ getREAL(String name) {return REAL_STORAGE.get(name);}
    public STRING_OBJ getSTRING(String name){return STRING_STORAGE.get(name);}
    public INTEGER_OBJ getINTEGER(String name){return INTEGER_STORAGE.get(name);}
    public DATE_OBJ getDATE(String name){return DATE_STORAGE.get(name);}
    public ENUM_OBJ getENUM(String name){return ENUM_STORAGE.get(name);}

}
