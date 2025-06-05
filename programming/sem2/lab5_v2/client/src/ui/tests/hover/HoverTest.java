package ui.tests.hover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Hover Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new FlowLayout());

        JPanel hoverArea = new JPanel();
        hoverArea.setPreferredSize(new Dimension(200, 150));
        hoverArea.setBackground(Color.LIGHT_GRAY);
        hoverArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Создаем всплывающее окно
        JWindow popup = new JWindow(frame);
        popup.setSize(150, 100);
        JLabel popupLabel = new JLabel("Это кастомное всплывающее окно!");
        popupLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        popup.add(popupLabel);
        popup.getContentPane().setBackground(new Color(255, 255, 200));
        popup.setVisible(false);

        hoverArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Показываем всплывающее окно рядом с курсором
                Point location = hoverArea.getLocationOnScreen();
                popup.setLocation(location.x + 50, location.y + 50);
                popup.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                popup.setVisible(false);
            }
        });

        frame.add(hoverArea);
        frame.setVisible(true);
    }
}