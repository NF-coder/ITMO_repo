package server.network;
import java.io.Serializable;
import java.util.HashMap;

public record NetworkDTO(String opName, HashMap<String,String> args) implements Serializable {}
