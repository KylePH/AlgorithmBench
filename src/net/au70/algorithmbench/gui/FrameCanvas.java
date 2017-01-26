package net.au70.algorithmbench.gui;

import java.awt.*;

public class FrameCanvas extends Canvas {

    public FrameCanvas() {
        setBackground(new Color(50, 50, 50));
        setSize(new Dimension(600, 500));
    }

    // Y = 10 is the top
    public void paint(Graphics gr) {
        Graphics2D g;
        g = (Graphics2D) gr;
        //g.setColor(new Color(255, 0, 0));
        //g.drawString("test!", 100, 10);
    }
}
