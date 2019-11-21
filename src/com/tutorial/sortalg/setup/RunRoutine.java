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

            // Run algorithm
            SortingNumber[] sortedData = algorithm.sort(dataToSort);

            // Obtain benchmark numbers after sorting
            long endTime = System.currentTimeMillis();
            System.out.println("Finished Sorting in: " + (endTime-startTime/1000) + " seconds");

            validate(sortedData);
        }
        System.out.println("Ending benchmarking.");
    }

    private static void validate(SortingNumber[] sortedData){
        for(int i = 0; i < sortedData.length; i++){
            SortingNumber currentNumber = sortedData[i];
            SortingNumber nextNumber = null;
            if(i+1 < sortedData.length){
                nextNumber = sortedData[i+1];
            }

            if(nextNumber!=null){
                if(currentNumber.getSortingValue()>nextNumber.getSortingValue()){
                    System.out.println("This array is NOT SORTED!");
                }else if(currentNumber.getSortingValue()==nextNumber.getSortingValue()
                        && currentNumber.getCounter()>nextNumber.getCounter()){
                    System.out.println("This array is NOT STABLE!");
                }
            }
        }
    }
}