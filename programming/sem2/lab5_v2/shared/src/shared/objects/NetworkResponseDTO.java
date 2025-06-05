package shared.objects;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * DTO для передачи от сервера к клиенту
 * @param result результат работы команды
 */
public record NetworkResponseDTO(String result) implements Serializable {}
