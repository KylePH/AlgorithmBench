package net.au70.algorithmbench.algorithms;

import net.au70.algorithmbench.AlgorithmBench;

public class InsertionSort extends Algorithm {


    @Override
    public void run() {
        list = AlgorithmBench.frame.canvas.getList(); // list is type int[]. list is defined in Algorithm.java.

        // Use while loops instead of for loops so that we can limit the speed that this is solved.
        // Loop city bitch
        int temp;
        int i = 1;
        long time1 = System.nanoTime();
        long timeStart = time1;
        long time2;
        while(i < list.length) {
            if(stop) break;
            //if((System.nanoTime() - time1) / 100000 >= step) {
                sentinel = i;
                //time1 = System.nanoTime();
                int j = i;
                time2 = System.nanoTime();
                while(j > 0) {
                    if((System.nanoTime() - time2) / 100000 >= step ) {
                        time2 = System.nanoTime();
                        if (list[j] < list[j - 1]) {
                            indexChangedFrom = j;
                            temp = list[j];
                            list[j] = list[j - 1];
                            list[j - 1] = temp;
                            indexChangedTo = j - 1;
                            arrayAccesses += 3;
                            AlgorithmBench.updateList(list, indexChangedTo, indexChangedFrom, sentinel);
                            AlgorithmBench.updateCounters(arrayAccesses, comparisons, timeElapsed);
                        }
                        comparisons++;
                        AlgorithmBench.updateScan(j);
                        j--;
                    }
                }
                i++;
                timeElapsed = (int)( (System.nanoTime() - timeStart) / 1000000L);
                AlgorithmBench.updateProgress((int)( ( (float)i / (float)list.length) * 100F));
            //}
        }

    }

    public String toString() {
        return "Insertion Sort";
    }
}
