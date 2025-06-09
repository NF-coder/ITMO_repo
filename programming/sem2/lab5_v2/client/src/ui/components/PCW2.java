package ui.components;

import org.json.JSONObject;
import ui.CityPanel;
import ui.utils.ReqBuilder;
import ui.utils.ReqController;
import ui.utils.enums.CityPopupOpt;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class PCW2 extends JFrame {
    private static Timer closeTimer;
    private static final int CLOSE_DELAY = 60000; // 60 секунд до закрытия
    private ReqController reqController;
    private boolean isEditable = false;

    public PCW2(JSONObject data, ReqController reqController) {
        this.setSize(350, 400);
        this.setUndecorated(true);

        this.reqController = reqController;

        buildUI(data);

        closeTimer = new Timer(CLOSE_DELAY, e -> {
            closeWindow();
            closeTimer.stop();
        });
        closeTimer.setRepeats(true);
        closeTimer.start();

        // Обработчики событий мыши
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // При наведении - останавливаем и сбрасываем таймер
                if (closeTimer != null) {
                    closeTimer.stop();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // При уходе курсора - запускаем таймер заново
                closeTimer.restart();
            }
        });
    }

    private void closeWindow() {
        this.dispose();
    }

    private void buildUI(JSONObject data){
        CityPanel cityPanel = new CityPanel(
                Double.toString(data.getDouble("area")),
                Float.toString(data.getFloat("metersAboveSeaLevel")),
                data.getString("climate"),
                data.getString("government"),
                data.getString("standardOfLiving"),
                data.getString("name"),
                ((Long) data.getLong("population")).toString(),
                Float.toString(data.getJSONObject("coordinates").getFloat("x")),
                Float.toString(data.getJSONObject("coordinates").getFloat("y")),
                data.getJSONObject("governor").getString("name"),
                Long.toString(data.getJSONObject("governor").getLong("age")),
                Double.toString(data.getJSONObject("governor").getDouble("height")),
                data.getJSONObject("governor").getString("birthday")
        );
        this.setContentPane(cityPanel.panel);


        cityPanel.setOptions(new CityPopupOpt[]{CityPopupOpt.EDIT, CityPopupOpt.DELETE});

        cityPanel.cancel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                closeWindow();
            }
        });
        cityPanel.delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reqController.call("remove_by_id").addArg("id", String.valueOf(data.getLong("id"))).build();
                closeWindow();
            }
        });
        cityPanel.edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isEditable = !isEditable;
                cityPanel.isEditable(isEditable);
                cityPanel.isCordsEditable(isEditable);

                if (isEditable) cityPanel.setOptions(new CityPopupOpt[]{CityPopupOpt.EDIT, CityPopupOpt.DELETE, CityPopupOpt.SAVE});
                else cityPanel.setOptions(new CityPopupOpt[]{CityPopupOpt.EDIT, CityPopupOpt.DELETE});
            }
        });
        cityPanel.save.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ReqBuilder rb = reqController.call("update");
                final HashMap<String, String> data = cityPanel.getData();

                for (String key: data.keySet()){
                    rb.addArg(key, data.get(key));
                }
                rb.build();
                closeWindow();
            }
        });
        this.getContentPane().setBackground(new Color(240, 240, 240));


    }
}
