package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class RelativePointPanel extends JPanel {
    private final List<Point2D.Float> relativePoints = new ArrayList<>();
    private Color pointColor = Color.RED;
    private int pointSize = 8;

    public RelativePointPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Добавляем точку с относительными координатами
                addRelativePoint(e.getX(), e.getY());
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
    public void addRelativePoint(float x, float y) {
        if (getWidth() == 0 || getHeight() == 0) return;

        // Преобразуем абсолютные координаты в относительные (0.0-1.0)
        float relX = x / getWidth();
        float relY = y / getHeight();
        relativePoints.add(new Point2D.Float(relX, relY));
        repaint();
    }

    // Преобразование относительных координат в абсолютные
    private Point getAbsolutePoint(Point2D.Float relPoint) {
        int x = (int) (relPoint.x * getWidth());
        int y = (int) (relPoint.y * getHeight());
        return new Point(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Рисуем все точки
        g.setColor(pointColor);
        for (Point2D.Float relPoint : relativePoints) {
            Point absPoint = getAbsolutePoint(relPoint);
            g.fillOval(absPoint.x - pointSize/2, absPoint.y - pointSize/2, pointSize, pointSize);
        }
    }

    // Сохранение точек
    public List<Point2D.Float> getPoints() {
        return new ArrayList<>(relativePoints);
    }

    // Загрузка точек
    public void setPoints(List<Point2D.Float> points) {
        relativePoints.clear();
        relativePoints.addAll(points);
        repaint();
    }
}