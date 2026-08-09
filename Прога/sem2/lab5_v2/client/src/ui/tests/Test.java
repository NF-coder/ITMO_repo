package ui.tests;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Пример CardLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Создаем панель с CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Создаем первую панель
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Это первая панель"));
        JButton toPanel2Button = new JButton("Перейти к панели 2");
        panel1.add(toPanel2Button);

        // Создаем вторую панель
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Это вторая панель"));
        JButton toPanel1Button = new JButton("Вернуться к панели 1");
        panel2.add(toPanel1Button);

        // Добавляем панели в cardPanel
        cardPanel.add(panel1, "Panel1");
        cardPanel.add(panel2, "Panel2");

        // Добавляем обработчики кнопок
        toPanel2Button.addActionListener(e -> cardLayout.show(cardPanel, "Panel2"));
        toPanel1Button.addActionListener(e -> cardLayout.show(cardPanel, "Panel1"));

        // Добавляем cardPanel в окно
        frame.add(cardPanel);

        // Показываем окно
        frame.setVisible(true);
    }
}