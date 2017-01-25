package net.au70.algorithmbench.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JPanel {

    public Frame(int width, int height) {

        width += 16; // +16 and +40 to account for the stuff Windows does. ridiculous
        height += 40;

        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setSize(width, height);
        f.setTitle("Algorithm Benchmark");
        f.setVisible(true);
        f.setFocusable(true);
        f.setBackground(new Color(0, 0, 0));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);


        // Make the container at the bottom. todo: add this to a new class
        int containerHeight = 64;
        int containerWidth = width;
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(new Color(255, 255, 255));
        container.setSize(containerWidth, containerHeight);
        container.setLocation(0, height - containerHeight);
        container.setVisible(true);
        container.setEnabled(true);

        JButton button = new JButton("Test");
        container.add(button);

        f.add(container);
        

    }

    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;


    }

}
