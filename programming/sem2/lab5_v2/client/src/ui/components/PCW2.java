package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class PCW2 extends JWindow {
    private static Timer closeTimer;
    private static final int CLOSE_DELAY = 3000; // 3 секунды до закрытия

    public PCW2() {
        this.setSize(200, 100);

        buildUI();

        closeTimer = new Timer(CLOSE_DELAY, e -> {
            this.dispose();
            closeTimer.stop();
        });
        closeTimer.setRepeats(true);
        closeTimer.start();

        // Обработчики событий мыши
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // При наведении - останавливаем и сбрасываем таймер
                if (closeTimer != null) {
                    closeTimer.stop();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // При уходе курсора - запускаем таймер заново
                closeTimer.restart();
            }
        });
    }

    private void buildUI(){

        //JLabel label = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/img.png"))));
        //this.add(label);

        JLabel popupLabel = new JLabel("Это всплывающее окно!");
        popupLabel.setHorizontalAlignment(SwingConstants.CENTER);

        popupLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(popupLabel);

        this.getContentPane().setBackground(new Color(240, 240, 240));
    }
}
