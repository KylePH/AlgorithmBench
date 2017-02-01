package net.au70.algorithmbench.algorithms;


public abstract class Algorithm extends Thread {


    int step = 100; // The length of each step in milliseconds.
    int[] list;
    int arrayAccesses = 0;
    int comparisons = 0;
    int timeElapsed = 0;
    int indexChangedTo;
    int indexChangedFrom;
    int sentinel;
    volatile boolean stop = false;

    @Override
    public void run(){

    }

    public void halt() {
        stop = true;
    }
    public void unhalt() {
        stop = false;
    }
    public String toString() {
        return "Generic Algorithm";
    }
}
