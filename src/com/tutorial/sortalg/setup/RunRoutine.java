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
}