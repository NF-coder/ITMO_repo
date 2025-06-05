package ui.tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class CLoc {

    public static class Panel extends JPanel {
        private final Ellipse2D circle = new Ellipse2D.Double(50, 50, 30, 30);

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Рисуем круглую точку
            g2d.setColor(Color.RED);
            g2d.fill(circle);

            // Обводка для красоты
            g2d.setColor(Color.BLACK);
            g2d.draw(circle);
        }

        public boolean isPointInCircle(Point p) {
            return circle.contains(p);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Круглая точка с JWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Панель для рисования круга
        Panel panel = new Panel();


        // Создаем всплывающее окно
        JWindow popup = new JWindow(frame);
        popup.setSize(200, 100);

        JLabel popupLabel = new JLabel("Это всплывающее окно!");
        popupLabel.setHorizontalAlignment(SwingConstants.CENTER);
        popupLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        popup.add(popupLabel);
        popup.getContentPane().setBackground(new Color(240, 240, 240));

        // Обработчик кликов
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (panel.isPointInCircle(e.getPoint())) {
                    // Позиционируем окно рядом с кругом
                    Point circleLocation = new Point(
                            (int) panel.getLocationOnScreen().getX() + 50 + 15, // x + центр круга
                            (int) panel.getLocationOnScreen().getY() + 50 + 15  // y + центр круга
                    );

                    popup.setLocation(circleLocation);
                    popup.setVisible(true);

                    // Автоматическое скрытие через 3 секунды
                    Timer timer = new Timer(3000, ev -> popup.setVisible(false));
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    popup.setVisible(false);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}