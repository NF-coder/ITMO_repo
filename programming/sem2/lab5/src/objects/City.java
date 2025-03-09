package objects;

import exceptions.UnacceptableValue;
import objects.enums.Climate;
import objects.enums.Government;
import objects.enums.StandardOfLiving;
import objects.validators.CityValidators;

import java.time.LocalDateTime;

public class City {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double area; //Значение поля должно быть больше 0
    private long population; //Значение поля должно быть больше 0
    private float metersAboveSeaLevel;
    private Climate climate; //Поле не может быть null
    private Government government; //Поле не может быть null
    private StandardOfLiving standardOfLiving; //Поле может быть null
    private Human governor; //Поле не может быть null

    public City(Long id, String name, Coordinates coordinates,
                LocalDateTime creationDate, double area, long population,
                float metersAboveSeaLevel, Climate climate, Government government,
                StandardOfLiving standardOfLiving, Human governor
                ) throws UnacceptableValue {
        this.id = id;
        this.name = CityValidators.validateName(name);
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = CityValidators.validateArea(area);
        this.population = CityValidators.validatePopulation(population);
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.climate = climate;
        this.government = government;
        this.standardOfLiving = standardOfLiving;
        this.governor = governor;
    }

    public Long getId() {
        return this.id;
    }

    public void setCreationDate(LocalDateTime creationDate){
        // TODO: checker there
        this.creationDate = creationDate;
    }
    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "City{" +
                "\n\tid=" + this.id + ", " +
                "\n\tname=" + this.name + ", " +
                "\n\tcoordinates=" + this.coordinates + ", " +
                "\n\tcreationDate=" + this.creationDate + ", " +
                "\n\tarea=" + this.area + ", " +
                "\n\tpopulation=" + this.population + ", " +
                "\n\tmetersAboveSeaLevel=" + this.metersAboveSeaLevel + ", " +
                "\n\tclimate=" + this.climate + ", " +
                "\n\tgovernment=" + this.government + ", " +
                "\n\tstandardOfLiving=" + this.standardOfLiving + ", " +
                "\n\tgovernor=" + this.governor + ", " +
                "\n}";
    }
}