package net.au70.algorithmbench.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JPanel {

    public Frame(int width, int height) {

        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setSize(width + 16, height + 40); // +16 and +40 to account for the stuff Windows does. ridiculous
        f.setTitle("Algorithm Benchmark");
        f.setVisible(true);
        f.setFocusable(true);
        f.setBackground(new Color(0, 0, 0));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;


    }

}
