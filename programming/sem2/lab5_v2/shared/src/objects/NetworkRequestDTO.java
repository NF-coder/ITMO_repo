package shared.objects;
import java.io.Serializable;
import java.net.SocketAddress;
import java.util.HashMap;

/**
 * DTO для передачи данных от клиента к серверу (де-факто своеобразный RPC)
 * @param opName название операции
 * @param args аргументы
 */
public record NetworkRequestDTO(String opName, HashMap<String,String> args) implements Serializable {}
