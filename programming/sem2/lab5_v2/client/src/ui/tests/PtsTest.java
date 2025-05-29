package ui.tests;

import ui.components.PointPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PtsTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Рисование точек");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Создаем панель для точек
        PointPanel pointPanel = new PointPanel();
        pointPanel.setBackground(Color.WHITE);

        // Панель управления
        JPanel controlPanel = new JPanel();

        // Кнопка для добавления случайной точки
        JButton addRandomButton = new JButton("Добавить случайную точку");
        addRandomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = (int)(Math.random() * pointPanel.getWidth());
                int y = (int)(Math.random() * pointPanel.getHeight());
                pointPanel.addPoint(x, y);
            }
        });

        // Кнопка для очистки
        JButton clearButton = new JButton("Очистить");
        clearButton.addActionListener(e -> pointPanel.clearPoints());

        // Добавляем компоненты
        controlPanel.add(addRandomButton);
        controlPanel.add(clearButton);

        frame.add(pointPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}