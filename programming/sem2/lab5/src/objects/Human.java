package objects;

import java.time.LocalDateTime;

public class Human {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long age; //Значение поля должно быть больше 0
    private double height; //Значение поля должно быть больше 0
    private java.time.LocalDateTime birthday;

    public Human(String name, long age, double height, LocalDateTime birthday){
        this.name = name;
        this.age = age;
        this.height = height;
        this.birthday = birthday;
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