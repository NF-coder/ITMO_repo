package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RelativePointPanel extends JPanel {
    private final List<RelativePoint> relativePoints = new ArrayList<>();

    public RelativePointPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (Long id: pointsIdsByCords(e.getX(), e.getY())){
                    System.out.println("PTR_ON: " + id);

                    PCW2 popup = new PCW2();

                    popup.setLocation(new Point(e.getXOnScreen(), e.getYOnScreen()));
                    popup.setVisible(true);


                }
            }
        });

        // Слушатель изменения размеров
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint(); // Перерисовываем при изменении размеров
            }
        });
    }

    public ArrayList<Long> pointsIdsByCords (float x, float y) {
        return this.relativePoints.stream()
                .filter(point -> {
                    Point cords = getAbsoluteCoordinates(point);
                    return cords.x - point.radius <= x &&
                            x <= cords.x + point.radius &&
                            cords.y - point.radius <= y &&
                            y <= cords.y + point.radius ; // Упрощаем зону клика до квадрата. Потом разберусь
                }).map(
                        point -> point.instanceId
                ).collect(
                        Collectors.toCollection(ArrayList::new)
                );
    }

    public void addRelPoint(float x, float y) {
        relativePoints.add(new RelativePoint(x, y));
        repaint();
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
            g.setColor(Color.decode(relPoint.color));
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