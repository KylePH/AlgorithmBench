package net.au70.algorithmbench;

import net.au70.algorithmbench.gui.Frame;

public class AlgorithmBench {

    Frame frame;

    public AlgorithmBench() {
        frame = new Frame(500, 500);
    }

    public static void main(String[] args) {
        new AlgorithmBench();
    }
}
