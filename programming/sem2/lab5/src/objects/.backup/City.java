package objects;

import exceptions.UnacceptableValue;
import objects.converters.Converters;
import objects.enums.Climate;
import objects.enums.Government;
import objects.enums.StandardOfLiving;
import objects.parsers.InvokersParsers.CityParser;
import objects.validators.CityValidators;

import java.time.LocalDateTime;

public class City {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final double area; //Значение поля должно быть больше 0
    private final long population; //Значение поля должно быть больше 0
    private final float metersAboveSeaLevel;
    private final Climate climate; //Поле не может быть null
    private final Government government; //Поле не может быть null
    private final StandardOfLiving standardOfLiving; //Поле может быть null
    private final Human governor; //Поле не может быть null

    public City(Long id, String name,
                LocalDateTime creationDate,
                String area, String population,
                String metersAboveSeaLevel
    ) throws UnacceptableValue {
        this.id = id;
        this.name = CityValidators.validateName(
                name
        );
        this.coordinates = new Coordinates();
        this.creationDate = creationDate;
        this.area = CityValidators.validateArea(
                Converters.StringToPrimitiveDouble(
                        area
                )
        );
        this.population = CityValidators.validatePopulation(
                Converters.StringToPrimitiveLong(
                        population
                )
        );
        this.metersAboveSeaLevel = Converters.StringToPrimitiveFloat(
                metersAboveSeaLevel
        );
        this.climate = CityParser.getClimate();
        this.government = CityParser.getGovernment();
        this.standardOfLiving = CityParser.getStandardOfLiving();
        this.governor = new Human();
    }

    public String toCSV() {
        return this.id.toString() + ", " +
                this.name + ", " +
                this.coordinates.toCSV() + ", " +
                String.valueOf(area) + ", " +
                String.valueOf(population) + ", " +
                String.valueOf(metersAboveSeaLevel) + ", " +
                climate.toString() + ", " +
                government.toString() + ", " +
                standardOfLiving.toString() + ", "+
                governor.toCSV();
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }

    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }
    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }

    public String getName(){
        return this.name;
    }

    public String getStandardOfLiving(){
        return this.standardOfLiving.toString();
    }

    public float getSeaLevel(){
        return this.metersAboveSeaLevel;
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