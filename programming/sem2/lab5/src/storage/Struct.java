package storage;

import exceptions.ElementNotFound;
import objects.City;

import java.util.ArrayDeque;

public class Struct {
    private ArrayDeque<City> mainCollection = new ArrayDeque<>();

    public ArrayDeque<City> getAllEntities(){
        return new ArrayDeque<>(this.mainCollection);
    }

    public void removeById(Long id){
        ArrayDeque<City> newCollection = new ArrayDeque<>();
        for (City elem: this.getAllEntities()){
            if (!elem.getId().equals(id)){
                newCollection.addLast(elem);
            }
        }
        mainCollection = newCollection;
    }

    public void removeFirst(){
        mainCollection.removeFirst();
    }

    public void clearCollection(){
        this.mainCollection.clear();
    }

    public void removeAllByStandardOfLiving(String standardOfLiving) {
        ArrayDeque<City> newCollection = new ArrayDeque<City>();
        for (City elem : this.getAllEntities()) {
            if (elem.getStandardOfLiving().equals(standardOfLiving)) {
                newCollection.addLast(elem);
            }
        }
        mainCollection = newCollection;
    }

    public float averageOfMetersAboveSeaLevel(){
        float seaLevelSum = 0f;
        for (City entity: this.getAllEntities()){
            seaLevelSum = seaLevelSum + entity.getSeaLevel();
        }
        return seaLevelSum/(float) mainCollection.size();
    }

    public void updateEntityById(Long id, City newEntity) throws ElementNotFound {
        boolean ELEMENT_UPDATED_FLAG = false;

        ArrayDeque<City> newArray = new ArrayDeque<>();
        for (City element: this.mainCollection){
            if (element.getId().equals(id)){

                newEntity.setCreationDate(
                        element.getCreationDate()
                );
                newEntity.setId(id);
                newArray.addLast(
                        newEntity
                );
                ELEMENT_UPDATED_FLAG = true;
            }
            else{
                newArray.addLast(element);
            }
        }

        this.mainCollection = newArray;

        if (!ELEMENT_UPDATED_FLAG){
            throw new ElementNotFound("No such element in collection!");
        }
    }
}
