package ui;


import ui.components.JPanelWithBg;
import ui.components.RelativePointPanel;

import javax.swing.*;


public class MapLayout extends JFrame implements Runnable{
    private JPanel panel1;
    private JPanelWithBg JPanelWithBg1;
    private RelativePointPanel relativePointPanel1;

    public MapLayout() {
        this.setTitle("Map");
        this.setSize(800, 600);
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(this::createAllPts);
    }

    public void run() {
        MapLayout frame = new MapLayout();
        frame.setVisible(true);
    }

    private void createAllPts(){

        relativePointPanel1.addRelPoint((float) 1 /477, (float) 8 /477);
        relativePointPanel1.addRelPoint((float) 200/477, (float) 200/477);
        relativePointPanel1.addRelPoint((float) 100 /477, (float) 300 /477);
    }
}
