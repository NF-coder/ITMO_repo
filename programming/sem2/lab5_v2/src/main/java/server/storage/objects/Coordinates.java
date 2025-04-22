package server.storage.objects;


public class Coordinates {
    private final double x;
    private final Float y; //Максимальное значение поля: 447, Поле не может быть null

    public Coordinates(String x, String y) {
        this.x = Double.parseDouble(x);
        this.y = Float.parseFloat(y);
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