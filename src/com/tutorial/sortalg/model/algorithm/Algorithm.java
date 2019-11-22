package com.tutorial.sortalg.model.algorithm;

import java.util.Objects;
import java.util.function.Supplier;

public enum Algorithm {
    // Append as we add more algorithms
    SELECTION(SelectionSort::new),
    BUBBLE(BubbleSort::new),
    RECURSIVE_BUBBLE(RecursiveBubbleSort::new);


    // Supplier class variable
    public final Supplier<SortingAlgorithm> factory;

    // Constructor
    Algorithm(Supplier<SortingAlgorithm> factory){
        this.factory = Objects.requireNonNull(factory);
    }
}
