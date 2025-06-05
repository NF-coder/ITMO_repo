package ui.tests.hover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnimHoverTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animated Hover Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new FlowLayout());

        JPanel hoverArea = new JPanel();
        hoverArea.setPreferredSize(new Dimension(200, 150));
        hoverArea.setBackground(Color.LIGHT_GRAY);
        hoverArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Создаем кастомное всплывающее окно
        JWindow popup = new JWindow(frame);
        popup.setSize(200, 80);
        popup.setOpacity(0f); // Начальная прозрачность

        JPanel popupPanel = new JPanel(new BorderLayout());
        popupPanel.setBackground(new Color(255, 255, 180));
        popupPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel popupLabel = new JLabel("<html><center>Анимированное<br>всплывающее окно</center></html>");
        popupPanel.add(popupLabel, BorderLayout.CENTER);
        popup.add(popupPanel);

        Timer fadeInTimer = new Timer(10, e -> {
            if (popup.getOpacity() < 0.9f) {
                popup.setOpacity(popup.getOpacity() + 0.05f);
            } else {
                ((Timer)e.getSource()).stop();
            }
        });

        Timer fadeOutTimer = new Timer(10, e -> {
            if (popup.getOpacity() > 0.05f) {
                popup.setOpacity(popup.getOpacity() - 0.05f);
            } else {
                popup.setVisible(false);
                ((Timer)e.getSource()).stop();
            }
        });

        hoverArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                fadeOutTimer.stop();
                Point location = hoverArea.getLocationOnScreen();
                popup.setLocation(location.x + 30, location.y + 30);
                popup.setVisible(true);
                fadeInTimer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fadeInTimer.stop();
                fadeOutTimer.start();
            }
        });

        frame.add(hoverArea);
        frame.setVisible(true);
    }
}