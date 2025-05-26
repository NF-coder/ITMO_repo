package shared.objects;

import java.io.Serializable;
import java.util.HashMap;

/**
 * DTO для передачи от сервера к клиенту
 * @param result результат работы команды
 */
public record NetworkResponseDTO(HashMap<String,String> result) implements Serializable {}
