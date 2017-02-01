package net.au70.algorithmbench.gui;

<<<<<<< HEAD
import net.au70.algorithmbench.AlgorithmBench;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class FrameCanvas extends Canvas {

    private int[] currentList;
    private int[] translatedList;
    private int indexChangedTo;
    private int indexChangedFrom;
    private int sentinel;
    private int scan;

    public FrameCanvas() {
        setBackground(new Color(50, 50, 50));
        setSize(new Dimension(600, 358));
    }

    public void paint(Graphics gr) {
        Graphics2D g;
        g = (Graphics2D) gr;
        if(translatedList != null && translatedList.length > 0) {
            for (int i = 0; i < translatedList.length; i++) {
                if(i == indexChangedFrom) {
                    g.setColor(Color.RED);
                } else if (i == indexChangedTo) {
                    g.setColor(Color.GREEN);
                } else if(i == sentinel) {
                    g.setColor(Color.PINK);
                } else if(i == scan) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(new Color(0, 100, 255));
                }
                //g.drawLine(i, this.getHeight() - translatedList[i], i, this.getHeight());
                Rectangle2D rect = new Rectangle2D.Double(i * AlgorithmBench.barWidth, this.getHeight() - translatedList[i], AlgorithmBench.barWidth - 1, translatedList[i] * 3);
                g.fill(rect);
                g.draw(rect);
            }

        }

    }

    public void setList(int[] list) {
        currentList = list;
        translateList();
        //repaint();
    }

    public void setList(int[] list, int indexChangedTo, int indexChangedFrom) {
        currentList = list;
        this.indexChangedTo = indexChangedTo;
        this.indexChangedFrom = indexChangedFrom;
        translateList();
        //repaint();
    }

    public void setList(int[] list, int indexChangedTo, int indexChangedFrom, int sentinel) {
        currentList = list;
        this.indexChangedTo = indexChangedTo;
        this.indexChangedFrom = indexChangedFrom;
        this.sentinel = sentinel;
        translateList();
        //repaint();
    }

    public void setScan(int scan) {
        this.scan = scan;
        repaint();
    }

    public  int[] getList() {
        return currentList;
    }

    // Translates the list so that it can be easily drawn by the paint function.
    private void translateList() {
        translatedList = new int[currentList.length];
        float ratio = (float)this.getHeight() / ( (float) this.getWidth() / (float) AlgorithmBench.barWidth);
        for(int i = 0; i < currentList.length; i++) {
            translatedList[i] = (int)((float)currentList[i] * ratio);
        }
=======
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
>>>>>>> origin/master
    }
}
