package ui;


import ui.components.JPanelWithBg;
import ui.components.RelativePointPanel;

import javax.swing.*;


public class MapLayout extends JFrame implements Runnable{
    private JPanel panel1;
    private JPanelWithBg JPanelWithBg1;
    private RelativePointPanel relativePointPanel1;

    public void run() {
        MapLayout frame = new MapLayout();
        frame.setContentPane(frame.panel1);

        frame.setTitle("Hello World");
        frame.setSize(800, 600);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
