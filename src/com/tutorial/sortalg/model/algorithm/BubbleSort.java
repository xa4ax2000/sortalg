package com.tutorial.sortalg.model.algorithm;

import com.tutorial.sortalg.model.SortingNumber;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public String getAlgorithm() {
        return "BUBBLE SORT";
    }

    //[4, 3, 2, 1, 5]
    @Override
    public SortingNumber[] sort(SortingNumber[] data) {
        int n = data.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(data[j].getSortingValue()>data[j+1].getSortingValue()){
                    SortingNumber temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        return data;
    }
}
