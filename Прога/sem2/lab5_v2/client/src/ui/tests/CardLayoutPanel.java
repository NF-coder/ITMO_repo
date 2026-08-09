package ui.tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutPanel extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public CardLayoutPanel() {
        setTitle("CardLayout с переключением по кнопке");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Центрируем окно

        // Создаем менеджер компоновки CardLayout и панель для него
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Создаем несколько панелей для переключения
        JPanel firstPanel = createPanel("Первая панель", Color.LIGHT_GRAY);
        JPanel secondPanel = createPanel("Вторая панель", new Color(200, 200, 255));
        JPanel thirdPanel = createPanel("Третья панель", new Color(200, 255, 200));

        // Добавляем панели в CardLayout с уникальными именами
        cardPanel.add(firstPanel, "FIRST");
        cardPanel.add(secondPanel, "SECOND");
        cardPanel.add(thirdPanel, "THIRD");

        // Создаем кнопки для переключения панелей
        JButton prevButton = new JButton("Назад");
        JButton nextButton = new JButton("Вперед");

        // Обработчики для кнопок
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel); // Переключаем на предыдущую панель
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel); // Переключаем на следующую панель
            }
        });

        // Панель для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        // Добавляем компоненты в главное окно
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Метод для создания панелей с разным содержимым
    private JPanel createPanel(String text, Color bgColor) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bgColor);

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardLayoutPanel().setVisible(true);
            }
        });
    }
}