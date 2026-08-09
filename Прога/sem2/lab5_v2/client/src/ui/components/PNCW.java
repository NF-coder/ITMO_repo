package ui.components;

import org.json.JSONObject;
import ui.CityPanel;
import ui.utils.ReqBuilder;
import ui.utils.ReqController;
import ui.utils.enums.CityPopupOpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class PNCW extends JFrame{
    private static Timer closeTimer;
    private static final int CLOSE_DELAY = 60000; // 60 секунд до закрытия
    private ReqController reqController;

    public PNCW(ReqController reqController, float x, float y, Dimension pSize) {
        this.setSize(350, 400);
        this.setUndecorated(true);

        this.reqController = reqController;

        buildUI(x, y, pSize);

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

    private void buildUI(float x, float y, Dimension pSize){
        CityPanel cityPanel = new CityPanel(x/pSize.width*447, y/pSize.height*447);
        cityPanel.isCordsEditable(false);
        cityPanel.setOptions(new CityPopupOpt[]{CityPopupOpt.SAVE});

        this.setContentPane(cityPanel.panel);

        cityPanel.cancel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                closeWindow();
            }
        });
        this.getContentPane().setBackground(new Color(240, 240, 240));

        cityPanel.save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReqBuilder rb = reqController.call("add");
                final HashMap<String, String> data = cityPanel.getData();

                for (String key: data.keySet()){
                    rb.addArg(key, data.get(key));
                }
                rb.build();

                closeWindow();
            }
        });
    }
}
