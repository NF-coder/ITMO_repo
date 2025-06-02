package ui.components.deprecated;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PointPanel extends JPanel {

    public record RelPoint(float x, float y) {}

    private final List<RelPoint> points = new ArrayList<>();
    private Color pointColor = Color.RED;
    private int pointSize = 5;

    public PointPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Добавляем новую точку при клике
                addPoint(e.getX(), e.getY());
                repaint(); // Перерисовываем панель
            }
        });
    }

    // Метод для добавления точки по координатам
    public void addPoint(int x, int y) {
        points.add(
                new RelPoint((float) x / getWidth() , (float) y / getHeight()));
        repaint();
    }

    // Метод для очистки всех точек
    public void clearPoints() {
        points.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension sz = super.getSize();

        // Рисуем все точки
        g.setColor(pointColor);
        for (RelPoint p : points) {
            g.fillOval(
                    (int) (p.y*sz.height),
                    (int) (p.x*sz.width),

                    pointSize,
                    pointSize
            );
        }
    }

    // Геттеры и сеттеры
    public Color getPointColor() {
        return pointColor;
    }

    public void setPointColor(Color pointColor) {
        this.pointColor = pointColor;
        repaint();
    }

    public int getPointSize() {
        return pointSize;
    }

    public void setPointSize(int pointSize) {
        this.pointSize = pointSize;
        repaint();
    }

    public List<RelPoint> getPoints() {
        return new ArrayList<>(points);
    }
}