package net.au70.algorithmbench;

import net.au70.algorithmbench.algorithms.*;
import net.au70.algorithmbench.gui.Frame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AlgorithmBench {

<<<<<<< HEAD
    public static Frame frame;
    public static ArrayList<Algorithm> algorithms;
    public static int[] list;
    public static int barWidth;

    public AlgorithmBench() {
        algorithms = new ArrayList<>();
        addAlgorithms();
        frame = new Frame();
        frame.populateComboBox(algorithms);
        frame.start();
        barWidth = 10;
        list = generateRandomList(barWidth);
        updateList(this.list);
    }


    // Make sure to add each new algorithm to this list.
    public void addAlgorithms() {
        algorithms.add(new InsertionSort());
        algorithms.add(new RadixLSDSort());
        algorithms.add(new BubbleSort());
        algorithms.add(new QuickSort());

    }

    public static void updateList(int[] lis) {
        frame.canvas.setList(lis);
    }

    public static void updateList(int[] lis, int indexChangedTo, int indexChangedFrom) {
        frame.canvas.setList(lis, indexChangedTo, indexChangedFrom);
    }

    public static void updateList(int[] lis, int indexChangedTo, int indexChangedFrom, int sentinel) {
        frame.canvas.setList(lis, indexChangedTo, indexChangedFrom, sentinel);
    }

    public static void updateList() {
        list = generateRandomList(barWidth);
        frame.canvas.setList(list);
    }

    public static void updateScan(int scan) {
        frame.canvas.setScan(scan);
    }


    public static void updateCounters(int arrayAccesses, int comparisons, int timeElapsed) {
        frame.updateLabels(arrayAccesses, comparisons, timeElapsed);
    }

    public static void updateProgress(int progress) {
        frame.updateProgress(progress);
    }

    private static int[] generateRandomList(int barWidth) {
        int length = frame.canvas.getWidth() / barWidth;
        int[] randList =  new int[length];

        // Populate the list
        for(int i = 0; i < length; i++) {
            randList[i] = i + 1;
        }


        ArrayList<Integer> tempIntArray = new ArrayList<>();

        for(int i : randList) {
            tempIntArray.add(i);
        }

        long seed = System.nanoTime();
        Collections.shuffle(tempIntArray, new Random(seed));

        for(int i = 0; i < tempIntArray.size(); i++) {
            randList[i] = tempIntArray.get(i);
        }

        return randList;
=======
    public AlgorithmBench() {
        Frame.start();
>>>>>>> origin/master
    }

    public static void main(String[] args) {
        new AlgorithmBench();
    }
}
