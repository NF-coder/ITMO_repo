package server.storage.structures;
import objects.parsers.InvokersParsers.HumanParser;

public class Human {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long age; //Значение поля должно быть больше 0
    private double height; //Значение поля должно быть больше 0
    private java.time.LocalDateTime birthday;

    public Human() {
        this.name = HumanParser.getName();
        this.age = HumanParser.getAge();
        this.height = HumanParser.getHeight();
        this.birthday = HumanParser.getBirthDate();
    }

    public String toCSV(){
        return this.name + ", " +
                String.valueOf(age) + ", " +
                String.valueOf(height) + ", " +
                birthday.toString();
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