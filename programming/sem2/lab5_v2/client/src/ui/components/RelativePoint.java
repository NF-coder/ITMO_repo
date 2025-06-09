package ui.components;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;

public class RelativePoint {
    Float x;
    Float y;
    Color color;
    Integer radius;

    JSONObject data;

    public RelativePoint(float x, float y, int radius, Color color, JSONObject data) {
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.color=color;

        this.data=data;
    }
}
