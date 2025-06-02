package shared.objects;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;

/**
 * DTO для передачи от сервера к клиенту
 * @param result результат работы команды
 */
public record NetworkResponseDTO(JSONObject result) implements Serializable {}
