package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class JPanelWithBg extends JPanel {
    private final Image backgroundImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/img.png")));

    public JPanelWithBg() throws IOException {}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}