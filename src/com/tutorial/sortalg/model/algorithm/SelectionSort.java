package com.tutorial.sortalg.model.algorithm;

import com.tutorial.sortalg.model.SortingNumber;

import java.util.List;

public class SelectionSort implements SortingAlgorithm {
    @Override
    public String getAlgorithm() {
        return "SELECTION SORT";
    }

    @Override
    public SortingNumber[] sort(SortingNumber[] data) {
        for(int i = 0; i < data.length - 1; i++){
            int minimumIndex = i;

            for(int j = i+1; j < data.length; j++){
                if(data[minimumIndex].getSortingValue() > data[j].getSortingValue()){
                    minimumIndex = j;
                }
            }

            SortingNumber temp = data[i];
            data[i] = data[minimumIndex];
            data[minimumIndex] = temp;
        }

        return data;
    }
}
