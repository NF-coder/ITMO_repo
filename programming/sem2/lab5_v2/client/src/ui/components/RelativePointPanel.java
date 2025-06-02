package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class RelativePointPanel extends JPanel {
    private final List<RelativePoint> relativePoints = new ArrayList<>();
    private int pointSize = 8;

    public RelativePointPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Добавляем точку с относительными координатами
                addAbsPoint(e.getX(), e.getY());
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

    // Добавление точки с относительными координатами
    public void addAbsPoint(float x, float y) {
        if (getWidth() == 0 || getHeight() == 0) return;

        // Преобразуем абсолютные координаты в относительные (0.0-1.0)
        float relX = x / getWidth();
        float relY = y / getHeight();
        relativePoints.add(new RelativePoint(relX, relY));
        repaint();
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
            g.fillOval(absPoint.x - pointSize/2, absPoint.y - pointSize/2, relPoint.radius, relPoint.radius);
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