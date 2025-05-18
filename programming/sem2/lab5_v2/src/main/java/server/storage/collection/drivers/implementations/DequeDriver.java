package server.storage.collection.drivers.implementations;

import server.storage.collection.drivers.IStructDriver;
import server.storage.objects.City;
import server.storage.objects.exceptions.ElementNotFound;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class DequeDriver implements IStructDriver {
    private ArrayDeque<City> mainCollection = new ArrayDeque<>();
    private final LocalDateTime createdDateTime = LocalDateTime.now();


    /**
     * Генерация нового уникального идентификатора
     */
    private Long generateId(){
        return 1 + mainCollection.stream()
                .mapToLong(City::getId)
                .max()
                .orElse(0);
    }

    public synchronized void add(City entity){
        if (entity.getId() == null) {
            entity.setId(
                    this.generateId()
            );
        }
        if (entity.getCreationDate() == null) {
            entity.setCreationDate(
                    LocalDateTime.now()
            );
        }

        mainCollection.addLast(entity);
    }

    public synchronized ArrayDeque<City> getCollection(){
        //return new ArrayDeque<>(this.mainCollection);
        return this.mainCollection;
    }
    public synchronized void removeById(Long id){
        this.mainCollection = mainCollection.stream()
                .filter(item -> !item.getId().equals(id))
                .collect(Collectors.toCollection(ArrayDeque<City>::new));
    }
    public synchronized void removeFirst(){
        this.mainCollection.removeFirst();
    }
    public synchronized void clearCollection(){
        this.mainCollection.clear();
    }

    public synchronized City getById(Long id) throws ElementNotFound {
        for (City element: this.mainCollection){
            if (element.getId().equals(id)){
                return element;
            }
        }
        throw new ElementNotFound("No such element in collection!");
    }

    @Override
    public String toString() {
        return "Collection{" +
                "\n\tsize=" + this.mainCollection.size() +
                "\n\tcreated_time=" + createdDateTime +
                "}";
    }
}
