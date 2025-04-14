package client.network;
import java.util.HashMap;

public record NetworkDTO(String opName, HashMap<String,String> args) {}
