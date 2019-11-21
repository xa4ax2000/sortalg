package com.tutorial.sortalg.setup;

import com.tutorial.sortalg.model.SortingNumber;
import com.tutorial.sortalg.model.algorithm.Algorithm;
import com.tutorial.sortalg.model.algorithm.SortingAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunRoutine {

    private static SortingNumber[] unsortedData = new SortingNumber[1000000];
    private static List<SortingAlgorithm> algorithms = new ArrayList<>();

    /**
     * Loads the data and algorithms to be used for benchmarking space and time complexity
     */
    public static void load(){
        algorithms.iterator().remove();
        // Load Data
        Random random = new Random();
        for(int i = 0; i < unsortedData.length; i++){
            // Note: Can contain duplicates!
            unsortedData[i] = new SortingNumber(random.nextInt(1000000)+1);
        }

        // Load Algorithms
        for(Algorithm algorithm : Algorithm.values()) {
            algorithms.add(algorithm.factory.get());
        }
    }

    /**
     * Sort the data and obtain benchmarks
     */
    public static void benchmark(){
        System.out.println("Beginning benchmarking.");
        for(SortingAlgorithm algorithm : algorithms){
            System.out.println("Benchmarking: " + algorithm.getAlgorithm());

            // Create copy of data to sort
            SortingNumber[] dataToSort = new SortingNumber[1000000];
            System.arraycopy(unsortedData,0, dataToSort,0, unsortedData.length);

            // Obtain benchmark numbers before sorting
            long startTime = System.currentTimeMillis();
            List<Object> objectsCreatedByAlgorithm = new ArrayList<>();
            System.gc();
            long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Run algorithm


            // Obtain benchmark numbers after sorting
            long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long endTime = System.currentTimeMillis();
            System.out.println("Finished Sorting in: " + (endTime-startTime/1000) + " seconds");
            System.out.println("Memory used: " + (memoryAfter-memoryBefore) + " bytes");
        }
        System.out.println("Ending benchmarking.");
    }
}