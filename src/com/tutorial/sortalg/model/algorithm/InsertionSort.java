package com.tutorial.sortalg.model.algorithm;

import com.tutorial.sortalg.model.SortingNumber;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public String getAlgorithm() {
        return "Insertion Sort";
    }

    @Override
    public SortingNumber[] sort(SortingNumber[] data) {
        for(int i = 1; i < data.length; i++){
            SortingNumber unsortedNumberToInsert = data[i];

            int j = i-1;
            while(j >= 0 && unsortedNumberToInsert.getSortingValue()<data[j].getSortingValue()){
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = unsortedNumberToInsert;
        }
        return data;
    }
}
