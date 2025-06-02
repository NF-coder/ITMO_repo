package ui.components;

public class RelativePoint {
    Float x;
    Float y;
    String color;
    Integer radius;

    public RelativePoint(float x, float y) {
        this.x=x;
        this.y=y;
        this.radius=10;
        this.color="#00FFF0";
    }

    public RelativePoint(float x, float y, int radius) {
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.color="#00FFF0";
    }

    public RelativePoint(float x, float y, int radius, String color) {
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.color=color;
    }
}
