package ui.components;

public class RelativePoint {
    Float x;
    Float y;
    String color;
    Integer radius;

    Long instanceId;

    public RelativePoint(float x, float y) {
        this.x=x;
        this.y=y;
        this.radius=10;
        this.color="#00FFF0";

        this.instanceId = 0L;
    }

    public RelativePoint(float x, float y, int radius) {
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.color="#00FFF0";

        this.instanceId = 0L;
    }

    public RelativePoint(float x, float y, int radius, String color) {
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.color=color;

        this.instanceId = 0L;
    }
}
