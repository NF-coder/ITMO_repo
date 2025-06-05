package storage.collection.drivers.implementations;

import org.json.JSONObject;
import storage.collection.drivers.IStructDriver;
import storage.objects.City;
import storage.objects.exceptions.ElementNotFound;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class DequeDriver implements IStructDriver {
    private ArrayDeque<City> mainCollection = new ArrayDeque<>();
    private final LocalDateTime createdDateTime = LocalDateTime.now();
    private final ReentrantLock locker = new ReentrantLock();

    /**
     * Генерация нового уникального идентификатора
     */
    private Long generateId(){
        return 1 + mainCollection.stream()
                .mapToLong(City::getId)
                .max()
                .orElse(0);
    }

    public void add(City entity){
        locker.lock();
        try {
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
        } finally {
            locker.unlock();
        }

    }

    public ArrayDeque<City> getCollection(){
        //return new ArrayDeque<>(this.mainCollection);
        locker.lock();
        try {
            return this.mainCollection;
        } finally {
            locker.unlock();
        }
    }
    public void removeById(Long id){
        locker.lock();
        try {
            this.mainCollection = mainCollection.stream()
                .filter(item -> !item.getId().equals(id))
                .collect(Collectors.toCollection(ArrayDeque<City>::new));
        } finally {
            locker.unlock();
        }
    }
    public void removeFirst(){
        locker.lock();
        try {
            this.mainCollection.removeFirst();
        } finally {
            locker.unlock();
        }
    }
    public void clearCollection(){
        locker.lock();
        try {
            this.mainCollection.clear();
        } finally {
            locker.unlock();
        }
    }

    public City getById(Long id) throws ElementNotFound {
        locker.lock();
        try {
            for (City element: this.mainCollection){
                    if (element.getId().equals(id)){
                        return element;
                    }
                }
            throw new ElementNotFound("No such element in collection!");
        } finally {
            locker.unlock();
        }
    }

    @Override
    public String toString() {
        return "Collection{" +
                "\n\tsize=" + this.mainCollection.size() +
                "\n\tcreated_time=" + createdDateTime +
                "}";
    }

    @Override
    public JSONObject getJSON(){
        return new JSONObject()
                .put("driverName", "DequeDriver")
                .put("size", this.mainCollection.size())
                .put("created_time", createdDateTime);
    }
}
