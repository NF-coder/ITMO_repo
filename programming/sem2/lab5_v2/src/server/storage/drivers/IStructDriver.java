package server.storage.drivers;

import server.storage.objects.City;
import server.storage.objects.exceptions.ElementNotFound;

import java.time.LocalDateTime;
import java.util.ArrayDeque;

public interface IStructDriver {
    public void add(City entity);
    public City getById(Long id) throws ElementNotFound;
    public void removeById(Long id) ;
    public ArrayDeque<City> getCollectionCopy();
    public void removeFirst();
    public void clearCollection();
    public void removeByStandardOfLiving(String standardOfLiving);
    public float averageOfMetersAboveSeaLevel();
    public Long generateId();
    public LocalDateTime generateDateTime();
}
