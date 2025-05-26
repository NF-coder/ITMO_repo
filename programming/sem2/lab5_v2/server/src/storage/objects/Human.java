package storage.objects;
import storage.objects.exceptions.UnacceptableValue;
import storage.objects.interfaces.CSVSerializable;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Human implements CSVSerializable {
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final long age; //Значение поля должно быть больше 0
    private final double height; //Значение поля должно быть больше 0
    private final java.time.LocalDateTime birthday;
    private final DateTimeFormatter DTF = new DateTimeFormatterBuilder()
            .appendPattern("dd.MM.uuuu")
            //.optionalStart()
            //.appendPattern(" HH:mm")
            //.optionalEnd()
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .toFormatter();

    /**
     * Задание информации о человеке
     * @param name Имя человека
     * @param age Возраст человека
     * @param height Рост человека
     * @param birthday День рождения в формате ДД.ММ.ГГГГ
     * @throws UnacceptableValue Если какие-либо данные не прошли валидацию
     */
    public Human(String name, String age, String height, String birthday) throws UnacceptableValue{
        this.name = name;
        this.age = Long.parseLong(age);
        this.height = Double.parseDouble(height);
        this.birthday = this.DateStringToLocalDateTime(birthday);
    }

    // For auto json parsing

    /**
     * Имя человека
     * @return имя
     */
    public String getName() {return name;}

    /**
     * Возраст человека
     * @return возраст
     */
    public long getAge() {return age;}

    /**
     * Рост человека
     * @return рост
     */
    public double getHeight() {return height;}

    /**
     * День рождения человека
     * @return день рождения
     */
    public LocalDateTime getBirthday() {return birthday;}

    /**
     * Преобразование строки в дату рождения
     * @return Дата рождения в виде строки
     */
    private LocalDateTime DateStringToLocalDateTime(String value) throws UnacceptableValue {

        try {
            return LocalDateTime.parse(value, DTF);
        }
        catch (DateTimeException err){
            throw new UnacceptableValue("Проверьте правильность заполнения даты!");
        }
    }

    /**
     * Преобразование в CSV формат
     * @return csv-строка
     */
    public String toCSVString() {
        return name + "," + age + "," + height + "," + birthday.format(DTF);
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