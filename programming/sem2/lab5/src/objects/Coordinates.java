package objects;

import exceptions.UnacceptableValue;
import objects.validators.CoordinatesValidators;

public class Coordinates {
    private double x;
    private Float y; //Максимальное значение поля: 447, Поле не может быть null

    public Coordinates(double x, Float y) throws UnacceptableValue {
        this.x = CoordinatesValidators.validateCoordinate(x);
        this.y = CoordinatesValidators.validateCoordinate(y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + this.x + ", " +
                "y=" + this.y +
                "}";
    }
}