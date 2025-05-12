package server.storage.objects;
import server.storage.objects.exceptions.UnacceptableValue;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Human implements Serializable {
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final long age; //Значение поля должно быть больше 0
    private final double height; //Значение поля должно быть больше 0
    private final java.time.LocalDateTime birthday;

    public Human(String name, String age, String height, String birthday) throws UnacceptableValue{
        this.name = name;
        this.age = Long.parseLong(age);
        this.height = Double.parseDouble(height);
        this.birthday = this.DateStringToLocalDateTime(birthday);
    }

    // For auto json parsing
    public String getName() {return name;}
    public long getAge() {return age;}
    public double getHeight() {return height;}
    public java.time.LocalDateTime getBirthday() {return birthday;}

    private LocalDateTime DateStringToLocalDateTime(String value) throws UnacceptableValue {
        DateTimeFormatter DTF = new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.uuuu")
                //.optionalStart()
                //.appendPattern(" HH:mm")
                //.optionalEnd()
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .toFormatter();
        try {
            return LocalDateTime.parse(value, DTF);
        }
        catch (DateTimeException err){
            throw new UnacceptableValue("Проверьте правильность заполнения даты!");
        }
    }

    public String toCSVString() {
        return name + "," + age + "," + height + "," + birthday.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name=" + this.name + ", " +
                "age=" + this.age + ", " +
                "height=" + this.height + ", " +
                "birthday=" + this.birthday +
                "}";
    }
}