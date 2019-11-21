package com.tutorial.sortalg.setup;

import com.tutorial.sortalg.model.SortingNumber;
import com.tutorial.sortalg.model.algorithm.Algorithm;
import com.tutorial.sortalg.model.algorithm.SortingAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunRoutine {

    private static final int SIZE = 100000;
    private static SortingNumber[] unsortedData = new SortingNumber[SIZE];
    private static List<SortingAlgorithm> algorithms = new ArrayList<>();

    /**
     * Loads the data and algorithms to be used for benchmarking space and time complexity
     */
    public static void load(){
        // Load Data
        Random random = new Random();
        for(int i = 0; i < unsortedData.length; i++){
            // Note: Can contain duplicates!
            unsortedData[i] = new SortingNumber(random.nextInt(SIZE)+1);
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
            SortingNumber[] dataToSort = new SortingNumber[SIZE];
            System.arraycopy(unsortedData,0, dataToSort,0, unsortedData.length);

            // Obtain benchmark numbers before sorting
            long startTime = System.currentTimeMillis();

            // Run algorithm
            SortingNumber[] sortedData = algorithm.sort(dataToSort);

            // Obtain benchmark numbers after sorting
            long endTime = System.currentTimeMillis();
            System.out.println("Finished Sorting in: " + ((endTime-startTime)/1000) + " seconds");

            validate(sortedData);
        }
        System.out.println("Ending benchmarking.");
    }

    private static void validate(SortingNumber[] sortedData){
        boolean sorted = true;
        boolean stable = true;
        for(int i = 0; i < sortedData.length; i++){
            SortingNumber currentNumber = sortedData[i];
            SortingNumber nextNumber = null;
            if(i+1 < sortedData.length){
                nextNumber = sortedData[i+1];
            }

            if(nextNumber!=null){
                if(currentNumber.getSortingValue()>nextNumber.getSortingValue()){
                    sorted = false;
                }else if(currentNumber.getSortingValue()==nextNumber.getSortingValue()
                        && currentNumber.getCounter()>nextNumber.getCounter()){
                    stable = false;
                }
            }
        }

        if(sorted){
            System.out.println("SORTED: true");
        }else{
            System.out.println("SORTED: false");
        }
        if(stable){
            System.out.println("STABLE: true");
        }else{
            System.out.println("STABLE: false");
        }
    }
}