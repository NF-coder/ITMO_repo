package commands.utils;

import objects.City;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class AddUtils {
    public static Long findFreeId(ArrayDeque<City> cities){
        Long idx = 0L;
        for (City city : cities){
            if (city.getId() >= idx){
                idx = city.getId() + 1;
            }
        }
        return idx;
    }

    public static LocalDateTime generateLocalDateTime() {
        return LocalDateTime.now();
    }
}
