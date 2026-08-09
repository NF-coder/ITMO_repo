package ui;


import org.json.JSONArray;
import org.json.JSONObject;
import ui.components.JPanelWithBg;
import ui.components.RelativePoint;
import ui.components.RelativePointPanel;
import ui.utils.OKLCH;
import ui.utils.ReqController;
import ui.utils.storage.CitiesStorage;

import javax.swing.*;

import java.awt.*;
import java.util.Arrays;

import static java.lang.Math.*;


public class MapLayout extends JFrame{
    private JPanel panel1;
    private JPanelWithBg JPanelWithBg1;
    private RelativePointPanel relativePointPanel1;


    public MapLayout(ReqController reqController) {
        relativePointPanel1.setReqController(reqController);
        relativePointPanel1.setResync(this::syncAllPts);

        this.setTitle("Map");

        int part = 1200;
        this.setSize(part*2, part);

        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        new Thread(() -> {
            while (true){
                try{
                    this.syncAllPts(reqController);
                    Thread.sleep(10000);
                }
                catch (Exception ignored){}
            }
        }).start();
    }

    private void syncAllPts(ReqController reqController){
        JSONArray citiesArray = reqController.call("show").build()
                .getJSONObject("result")
                .getJSONArray("array");

        relativePointPanel1.clearPoints();

        citiesArray.forEach(
                elem -> {
                    if (elem instanceof JSONObject) {
                        JSONObject obj = (JSONObject) elem;
                        /*int[] okchRGB = OKLCH.run(
                                0.73,
                                0.10,
                                obj.getString("creator").hashCode()%360
                        );*/
                        int color = Color.HSBtoRGB(
                                obj.getString("creator").hashCode()%360,
                                0.82f,
                                0.18f
                        );
                        System.out.println(color + " " + Integer.toHexString(color));
                        relativePointPanel1.addRelPoint(
                                (float) (obj.getJSONObject("coordinates").getDouble("x") / 447),
                                (float) (obj.getJSONObject("coordinates").getDouble("y") / 447),
                                (int) (sqrt(obj.getLong("population"))*0.05 + 5),
                                new Color(color),
                                obj
                        );
                    }
                }
        );
    }
}
