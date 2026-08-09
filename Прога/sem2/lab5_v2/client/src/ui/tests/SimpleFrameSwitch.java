package ui.tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SimpleFrameSwitch{
    public static void main(String[] args) {
        // Главное окно-контейнер
        JFrame mainFrame = new JFrame("Переключение окон");
        mainFrame.setSize(500, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаем CardLayout и панель для него
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Создаем два "под-окна" как панели
        JPanel window1 = createWindowPanel("Окно 1", Color.LIGHT_GRAY);
        JPanel window2 = createWindowPanel("Окно 2", new Color(200, 230, 255));

        // Добавляем окна в CardLayout
        cardPanel.add(window1, "WINDOW1");
        cardPanel.add(window2, "WINDOW2");

        // Кнопки для переключения
        JButton switchToWindow2 = new JButton("Перейти к Окну 2");
        switchToWindow2.addActionListener(e -> cardLayout.show(cardPanel, "WINDOW2"));

        JButton switchToWindow1 = new JButton("Вернуться к Окну 1");
        switchToWindow1.addActionListener(e -> cardLayout.show(cardPanel, "WINDOW1"));

        // Добавляем кнопки в соответствующие окна
        window1.add(switchToWindow2, BorderLayout.SOUTH);
        window2.add(switchToWindow1, BorderLayout.SOUTH);

        // Добавляем CardLayout в главное окно
        mainFrame.add(cardPanel);
        mainFrame.setVisible(true);
    }

    private static JPanel createWindowPanel(String title, Color bgColor) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bgColor);

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }
}