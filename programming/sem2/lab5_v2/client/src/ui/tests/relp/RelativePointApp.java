package ui.tests.relp;

import ui.components.RelativePointPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Point2D;

public class RelativePointApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Относительные координаты точек");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        RelativePointPanel panel = new RelativePointPanel();
        panel.setBackground(Color.WHITE);

        // Панель управления
        JPanel controlPanel = new JPanel();
        JButton saveBtn = new JButton("Сохранить точки");
        JButton loadBtn = new JButton("Загрузить точки");

        // Сохранение состояния
        saveBtn.addActionListener(e -> {
            List<Point2D.Float> points = panel.getPoints();
            // Здесь можно сохранить points в файл или БД
            System.out.println("Точки сохранены: " + points);
        });

        // Загрузка состояния
        loadBtn.addActionListener(e -> {
            // Здесь можно загрузить points из файла или БД
            List<Point2D.Float> points = new ArrayList<>();
            points.add(new Point2D.Float(0.5f, 0.5f)); // Пример центральной точки
            panel.setPoints(points);
        });

        controlPanel.add(saveBtn);
        controlPanel.add(loadBtn);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}