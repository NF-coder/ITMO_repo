package server.storage.objects;

import server.storage.objects.exceptions.UnacceptableValue;
import server.storage.objects.enums.Climate;
import server.storage.objects.enums.Government;
import server.storage.objects.enums.StandardOfLiving;
import server.storage.objects.validators.CityValidators;

import java.time.LocalDateTime;

public class City {
    public final Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    public final String name; //Поле не может быть null, Строка не может быть пустой
    public final Coordinates coordinates; //Поле не может быть null
    public final LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    public final double area; //Значение поля должно быть больше 0
    public final long population; //Значение поля должно быть больше 0
    public final float metersAboveSeaLevel;
    public final Climate climate; //Поле не может быть null
    public final Government government; //Поле не может быть null
    public final StandardOfLiving standardOfLiving; //Поле может быть null
    public final Human governor; //Поле не может быть null

    public City(Long id,
                String name,
                LocalDateTime creationDate,
                String area,
                String population,
                String metersAboveSeaLevel,
                String climate,
                String government,
                String standardOfLiving,
                Coordinates coordinates,
                Human human

    ) throws UnacceptableValue {
        this.id = id;
        this.name = CityValidators.validateName(
                name
        );
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = CityValidators.validateArea(
                Double.parseDouble(area)
        );
        this.population = CityValidators.validatePopulation(
                Long.parseLong(population)
        );
        this.metersAboveSeaLevel = Float.parseFloat(
                metersAboveSeaLevel
        );
        this.climate = Climate.valueOf(climate);
        this.government = Government.valueOf(government);
        this.standardOfLiving = StandardOfLiving.valueOf(standardOfLiving);
        this.governor = human;
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