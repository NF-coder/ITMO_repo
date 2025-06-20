package storage.objects;

import org.json.JSONException;
import org.json.JSONObject;
import storage.objects.exceptions.UnacceptableValue;
import storage.objects.enums.Climate;
import storage.objects.enums.Government;
import storage.objects.enums.StandardOfLiving;
import storage.objects.interfaces.CSVSerializable;
import storage.objects.validators.CityValidators;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class City { // To JavaBean
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private double area; //Значение поля должно быть больше 0
    private long population; //Значение поля должно быть больше 0
    private float metersAboveSeaLevel;
    private Climate climate; //Поле не может быть null
    private Government government; //Поле не может быть null
    private StandardOfLiving standardOfLiving; //Поле может быть null
    private Human governor; //Поле не может быть null
    private String creator;

    public City() {}
    public City(HashMap<String,String> args) throws UnacceptableValue  {
        this.setCreator(args.get("login"));
        this.setName(args.get("name"));
        this.setArea(args.get("area"));
        this.setPopulation(args.get("population"));
        this.setMetersAboveSeaLevel(args.get("metersAboveSeaLevel"));
        this.setClimate(args.get("climate"));
        this.setGovernment(args.get("government"));
        this.setStandardOfLiving(args.get("standardOfLiving"));
        this.setCoordinates(
                new Coordinates(
                        args.get("x"),
                        args.get("y")
                )
        );
        this.setGovernor(
                new Human(
                        args.get("govName"),
                        args.get("age"),
                        args.get("height"),
                        args.get("birthday")
                )
        );
    }

    /**
     * Установка идентификатора города
     * @param id идентификатор города
     */
    public void setId(Long id) {this.id = id;}

    /**
     * Установка даты добавления объекта
     * @param creationDate дата добавления города
     */
    public void setCreationDate(LocalDateTime creationDate) {this.creationDate = creationDate;}
    /**
     * Установка имени города
     * @param name новое имя города
     */
    public void setName(String name) throws UnacceptableValue {this.name = CityValidators.validateName(name);}

    public void setCreator(String creator) {this.creator = creator;}
    public void setCoordinates(Coordinates coordinates) throws UnacceptableValue {this.coordinates = coordinates;}
    public void setArea(String area) throws UnacceptableValue {this.area = CityValidators.validateArea(Double.parseDouble(area));}
    public void setPopulation(String population) throws UnacceptableValue {this.population = CityValidators.validatePopulation(Long.parseLong(population));}
    public void setMetersAboveSeaLevel(String metersAboveSeaLevel) throws UnacceptableValue {this.metersAboveSeaLevel = Float.parseFloat(metersAboveSeaLevel);}
    public void setClimate(String climate) throws UnacceptableValue {this.climate = Climate.valueOf(climate);}
    public void setGovernment(String government) throws UnacceptableValue {this.government = Government.valueOf(government);}
    public void setStandardOfLiving(String standardOfLiving) throws UnacceptableValue {this.standardOfLiving = StandardOfLiving.valueOf(standardOfLiving);}
    public void setGovernor(Human human) throws UnacceptableValue {this.governor = human;}

    public String getCreator() {return creator;}
    public Long getId() {return id;}
    public LocalDateTime getCreationDate() {return creationDate;}
    public String getName() {return name;}
    public Coordinates getCoordinates() {return coordinates;}
    public double getArea() {return area;}
    public long getPopulation() {return population;}
    public float getMetersAboveSeaLevel() {return metersAboveSeaLevel;}
    public Climate getClimate() {return climate;}
    public Government getGovernment() {return government;}
    public StandardOfLiving getStandardOfLiving() {return standardOfLiving;}
    public Human getGovernor() {return governor;}

    public void fromCSVString(String csvString) throws UnacceptableValue {
        String[] csvArray = csvString.split(",");

        this.setId(Long.parseLong(csvArray[0]));
        this.setName(csvArray[1]);
        this.setCoordinates(new Coordinates(
                csvArray[2], csvArray[3]
        ));
        this.setArea(csvArray[4]);
        this.setPopulation(csvArray[5]);
        this.setMetersAboveSeaLevel(csvArray[6]);
        this.setClimate(csvArray[7]);
        this.setGovernment(csvArray[8]);
        this.setStandardOfLiving(csvArray[9]);
        this.setGovernor(new Human(
                csvArray[10],
                csvArray[11],
                csvArray[12],
                csvArray[13]
        ));
        this.setCreationDate(LocalDateTime.parse(csvArray[14], DateTimeFormatter.ISO_DATE_TIME));
    }
    @Override
    public String toString() {
        return "City{" +
                "\n\tcreator=" + creator +
                "\n\tid=" + id +
                "\n\tname=" + this.name + ", " +
                "\n\tcoordinates=" + this.coordinates + ", " +
                "\n\tarea=" + this.area + ", " +
                "\n\tpopulation=" + this.population + ", " +
                "\n\tmetersAboveSeaLevel=" + this.metersAboveSeaLevel + ", " +
                "\n\tclimate=" + this.climate + ", " +
                "\n\tgovernment=" + this.government + ", " +
                "\n\tstandardOfLiving=" + this.standardOfLiving + ", " +
                "\n\tgovernor=" + this.governor + ", " +
                "\n\tcreationDate=" + this.creationDate + ", " +
                "\n}";
    }

    public JSONObject toJSON() {
        return new JSONObject()
                .put("id", id)
                .put("name", name)
                .put("coordinates", coordinates.toJSON())
                .put("area", area)
                .put("population", population)
                .put("metersAboveSeaLevel", metersAboveSeaLevel)
                .put("climate", climate)
                .put("government", government)
                .put("standardOfLiving", standardOfLiving)
                .put("governor", governor.toJSON())
                .put("creationDate", creationDate)
                .put("creator", creator);
    }
}