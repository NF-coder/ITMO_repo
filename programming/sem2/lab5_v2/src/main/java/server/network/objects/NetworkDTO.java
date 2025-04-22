package server.network.objects;
import java.io.Serializable;
import java.util.HashMap;

public record NetworkDTO(String opName, HashMap<String,String> args) implements Serializable {}
