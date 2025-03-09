package workers;

import exceptions.ElementNotFound;
import objects.City;

import java.time.LocalDateTime;
import java.util.ArrayDeque;

public final class Reciver {
    private static ArrayDeque<City> mainCollection = new ArrayDeque<>();
    private final static LocalDateTime createdDateTime = LocalDateTime.now();

    public void addEntity(City entity){
        mainCollection.addLast(entity);
    }
    public ArrayDeque<City> getAllEntities(){
        return new ArrayDeque<City>(Reciver.mainCollection);
    }
    public void clearCollection(){
        Reciver.mainCollection.clear();
    }
    public void updateEntityById(Long id, City newEntity) throws ElementNotFound{
        boolean ELEMENT_UPDATED_FLAG = false;

        ArrayDeque<City> newArray = new ArrayDeque<>();
        for (City element: Reciver.mainCollection){
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

        Reciver.mainCollection = newArray;

        if (!ELEMENT_UPDATED_FLAG){
            throw new ElementNotFound("No such element in collection!");
        }
    }
    @Override
    public String toString(){
        return "Reciver{" +
                "createdDateTime = " + Reciver.createdDateTime.toString() + ", " +
                "collectionLenght = " + Reciver.mainCollection.size() +
                "}";
    }
}
