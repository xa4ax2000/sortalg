package com.tutorial.sortalg.model.algorithm;

import com.tutorial.sortalg.model.SortingNumber;

public class RecursiveBubbleSort implements SortingAlgorithm {
    @Override
    public String getAlgorithm() {
        return "Recursive Bubble Sort";
    }

    @Override
    public SortingNumber[] sort(SortingNumber[] data) {
        sort(data, data.length);
        return data;
    }

    private void sort(SortingNumber[] data, int length){
        if(length==1){
            return;
        }

        for(int i = 0; i < length-1; i++){
            if(data[i].getSortingValue()>data[i+1].getSortingValue()){
                SortingNumber temp = data[i];
                data[i] = data[i+1];
                data[i+1] = temp;
            }
        }

        sort(data, length-1);
    }
}
