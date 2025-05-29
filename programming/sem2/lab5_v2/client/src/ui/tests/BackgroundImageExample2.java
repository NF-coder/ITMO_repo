package ui.tests;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class BackgroundImageExample2 extends JPanel {
    private BufferedImage backgroundImage;

    public BackgroundImageExample2() {
        try {
            // Load the image
            backgroundImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/img.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Background Image Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the panel with background
        BackgroundImageExample2 panel = new BackgroundImageExample2();
        panel.setLayout(new BorderLayout());

        // Add components
        //JButton button = new JButton("Click Me");
        //panel.add(button, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}