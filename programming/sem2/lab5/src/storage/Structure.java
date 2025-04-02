package storage;

import exceptions.ElementNotFound;
import objects.City;

import java.time.LocalDateTime;
import java.util.ArrayDeque;

public final class Structure {
    private static ArrayDeque<City> mainCollection = new ArrayDeque<>();
    private final static LocalDateTime createdDateTime = LocalDateTime.now();

    /**
     * Этот метод реализует добавление новой сущности в коллекцию
     * @param entity Новая сущность
     */
    public void addEntity(City entity){
        mainCollection.addLast(entity);
    }

    /**
     * Этот метод реализует получение копии двусторонней очереди
     * @return ArrayDeque<City> Копия структуры
     */
    public ArrayDeque<City> getAllEntities(){
        return new ArrayDeque<>(Structure.mainCollection);
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
        Structure.mainCollection.clear();
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

    public void updateEntityById(Long id, City newEntity) throws ElementNotFound{
        boolean ELEMENT_UPDATED_FLAG = false;

        ArrayDeque<City> newArray = new ArrayDeque<>();
        for (City element: Structure.mainCollection){
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

        Structure.mainCollection = newArray;

        if (!ELEMENT_UPDATED_FLAG){
            throw new ElementNotFound("No such element in collection!");
        }
    }

    public String toCSV(){
        String out = "";
        for (City elem : this.getAllEntities()){
            out += elem.toCSV() + "\n";
        }
        return out;
    }
    public void fromCSV(String fileData){
        for (String line : fileData.split("\n")){
            System.out.println(line);
        }
    }
    @Override
    public String toString(){
        return "Receiver{" +
                "createdDateTime = " + Structure.createdDateTime.toString() + ", " +
                "collectionLength = " + Structure.mainCollection.size() +
                "}";
    }
}
