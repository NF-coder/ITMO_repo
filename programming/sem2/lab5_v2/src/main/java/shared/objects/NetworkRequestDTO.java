package shared.objects;
import java.io.Serializable;
import java.net.SocketAddress;
import java.util.HashMap;

public record NetworkRequestDTO(String opName, HashMap<String,String> args) implements Serializable {}
