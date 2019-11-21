package com.tutorial.sortalg.model;

public class SortingNumber {

    private static int sortingNumberInstances = 0;
    // The value to be sorted
    private int sortingValue;
    // This object's creation counter
    private int counter;

    // Constructor
    public SortingNumber(int sortingValue){
        sortingNumberInstances++;
        this.sortingValue = sortingValue;
        this.counter = sortingNumberInstances;
    }

    public int getSortingValue() {
        return sortingValue;
    }

    public int getCounter() {
        return counter;
    }

}
