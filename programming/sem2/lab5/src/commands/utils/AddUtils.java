package commands.utils;

import objects.City;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class AddUtils {
    public static Long findFreeId(ArrayDeque<City> cities){
        Long idx = 0L;
        while (true){
            try {
                Long elementIdx = cities.removeFirst().getId();
                if (elementIdx > idx){
                    idx = elementIdx + 1;
                }
            }
            catch (NoSuchElementException exc) {
                return idx;
            }
        }
    }

    public static LocalDateTime generateLocalDateTime() {
        return LocalDateTime.now();
    }
}
