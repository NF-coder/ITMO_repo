package server.storage.objects;


import java.io.Serializable;

public class Coordinates implements Serializable {
    private final double x;
    private final Float y; //Максимальное значение поля: 447, Поле не может быть null

    public Coordinates(String x, String y) {
        this.x = Double.parseDouble(x);
        this.y = Float.parseFloat(y);
    }

    // For auto json parsing
    public double getX() {return x;}
    public Float getY() {return y;}

    public String toCSV(){
        return x + ", " + y.toString();
    }

    public String toCSVString() {
        return x + "," + y;
    }
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + this.x + ", " +
                "y=" + this.y +
                "}";
    }
}