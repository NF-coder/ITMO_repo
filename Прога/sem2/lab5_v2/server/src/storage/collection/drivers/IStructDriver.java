package storage.collection.drivers;

import org.json.JSONObject;
import storage.objects.City;
import storage.objects.exceptions.ElementNotFound;

import java.util.ArrayDeque;

public interface IStructDriver {
    /**
     * Этот метод реализует добавление новой сущности в коллекцию
     * @param entity Новая сущность
     */
    void add(City entity);

    /**
     * Получение объекта по идентификатору
     * @param id идентификатор объекта
     */
    City getById(Long id) throws ElementNotFound;
    /**
     * Удаление объекта по идентификатору. Если такого идентификатора нет - коллекция остаётся прежней
     * @param id идентификатор объекта
     */
    void removeById(Long id);
    /**
     * Этот метод реализует получение ссылки на текущую коллекцию
     * @return Копия структуры
     */
    ArrayDeque<City> getCollection();
    /**
     * Удаление объекта коллекции
     */
    void removeFirst();
    /**
     * Очистка коллекции
     */
    void clearCollection();

    JSONObject getJSON();
}
