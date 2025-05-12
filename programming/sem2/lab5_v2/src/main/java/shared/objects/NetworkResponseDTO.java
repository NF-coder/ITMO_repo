package shared.objects;

import java.io.Serializable;
import java.util.HashMap;

public record NetworkResponseDTO<T>(T result) implements Serializable {}
