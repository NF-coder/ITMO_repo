package ui.components;

import org.json.JSONObject;
import ui.CityPanel;
import ui.utils.ReqController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RelativePointPanel extends JPanel {
    private final List<RelativePoint> relativePoints = Collections.synchronizedList(new ArrayList<>());
    private ReqController reqController;
    private Consumer<ReqController> resync;

    public RelativePointPanel() {
        // Слушатель изменения размеров
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint(); // Перерисовываем при изменении размеров
            }
        });
    }

    public void setResync(Consumer<ReqController> resync) {
        this.resync = resync;
    }

    public void setReqController(ReqController reqController) {
        this.reqController = reqController;
        System.out.println("SRQ: " + reqController);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList<JSONObject> pointsCache = pointsIdsByCords(e.getX(), e.getY());
                if (pointsCache.isEmpty()) {
                    PNCW popup = new PNCW(reqController, e.getX(), e.getY(), getSize());
                    popup.setLocation(new Point(e.getXOnScreen(), e.getYOnScreen()));
                    popup.setVisible(true);
                }
                for (JSONObject data : pointsCache){
                    SwingUtilities.invokeLater(() -> {
                        PCW2 popup = new PCW2(data, reqController);
                        popup.setLocation(new Point(e.getXOnScreen(), e.getYOnScreen()));
                        popup.setVisible(true);
                    });
                }
                resync.accept(reqController);
            }
        });
    }

    public ArrayList<JSONObject> pointsIdsByCords (float x, float y) {
        return this.relativePoints.stream()
                .filter(point -> {
                    Point cords = getAbsoluteCoordinates(point);
                    return cords.x - point.radius <= x &&
                            x <= cords.x + point.radius &&
                            cords.y - point.radius <= y &&
                            y <= cords.y + point.radius ; // Упрощаем зону клика до квадрата. Потом разберусь
                }).map(
                        point -> point.data
                ).collect(
                        Collectors.toCollection(ArrayList::new)
                );
    }

    public void addRelPoint(float x, float y, int radius, Color color, JSONObject data) {
       // System.out.println(color);
        relativePoints.add(new RelativePoint(x, y, radius, color, data));
        repaint();
    }

    public void clearPoints() {
        relativePoints.clear();
    }

    // Преобразование относительных координат в абсолютные
    private Point getAbsoluteCoordinates(RelativePoint relPoint) {
        int x = (int) (relPoint.x * getWidth());
        int y = (int) (relPoint.y * getHeight());
        return new Point(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Рисуем все точки
        for (RelativePoint relPoint : relativePoints) {
            Point absPoint = getAbsoluteCoordinates(relPoint);
            g.setColor(relPoint.color);
            int pointSize = 8;
            g.fillOval(absPoint.x - pointSize /2, absPoint.y - pointSize /2, relPoint.radius, relPoint.radius);
        }
    }

    // Сохранение точек
    public List<RelativePoint> getPoints() {
        return new ArrayList<>(relativePoints);
    }

    // Загрузка точек
    public void setPoints(List<RelativePoint> points) {
        relativePoints.clear();
        relativePoints.addAll(points);
        repaint();
    }
}