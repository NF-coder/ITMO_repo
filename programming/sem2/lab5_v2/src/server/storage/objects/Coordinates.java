package server.storage.structures;

import objects.parsers.InvokersParsers.CoordinatesParser;

public class Coordinates {
    private double x;
    private Float y; //Максимальное значение поля: 447, Поле не может быть null

    public Coordinates() {
        this.x = CoordinatesParser.getX();
        this.y = CoordinatesParser.getY();
    }

    public String toCSV(){
        return String.valueOf(x) + ", " +
                y.toString();
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + this.x + ", " +
                "y=" + this.y +
                "}";
    }
}