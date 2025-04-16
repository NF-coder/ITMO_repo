package server.storage.drivers;

import server.storage.objects.City;
import server.storage.objects.enums.StandardOfLiving;
import server.storage.objects.exceptions.ElementNotFound;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class DequeDriver implements IStructDriver{
    private ArrayDeque<City> mainCollection = new ArrayDeque<>();
    private final static LocalDateTime createdDateTime = LocalDateTime.now();

    /**
     * Этот метод реализует добавление новой сущности в коллекцию
     * @param entity Новая сущность
     */
    public void add(City entity){
        mainCollection.addLast(entity);
    }

    /**
     * Этот метод реализует получение копии двусторонней очереди
     * @return ArrayDeque<City> Копия структуры
     */
    public ArrayDeque<City> getCollectionCopy(){
        return new ArrayDeque<>(this.mainCollection);
    }
    public void removeById(Long id){
        this.mainCollection = mainCollection.stream()
                .filter(item -> !item.id.equals(id))
                .collect(Collectors.toCollection(ArrayDeque<City>::new));
    }
    public void removeFirst(){
        this.mainCollection.removeFirst();
    }
    public void clearCollection(){
        this.mainCollection.clear();
    }
    public Long generateId(){
        return 1 + mainCollection.stream()
                .mapToLong(elem -> elem.id)
                .max()
                .orElse(0);
    }
    public void removeByStandardOfLiving(String standardOfLiving) {
        this.mainCollection = mainCollection.stream()
                .filter(item -> !item.standardOfLiving.equals(
                        StandardOfLiving.valueOf(standardOfLiving)
                ))
                .collect(Collectors.toCollection(ArrayDeque<City>::new));
    }
    public float averageOfMetersAboveSeaLevel(){
        return (float) mainCollection.stream()
                .mapToDouble(elem -> elem.metersAboveSeaLevel)
                .average()
                .orElse(Double.NaN);
    }
    public City getById(Long id) throws ElementNotFound {
        for (City element: this.mainCollection){
            if (element.id.equals(id)){
                return element;
            }
        }
        throw new ElementNotFound("No such element in collection!");
    }
    public LocalDateTime generateDateTime(){
        return LocalDateTime.now();
    }
}
