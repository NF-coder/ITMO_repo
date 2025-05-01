package shared.objects;

import java.io.Serializable;
import java.util.HashMap;

public record NetworkResponseDTO(HashMap<String,String> result) implements Serializable {}
