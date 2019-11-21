package com.tutorial.sortalg.model.algorithm;

import com.tutorial.sortalg.model.SortingNumber;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public String getAlgorithm() {
        return "BUBBLE SORT";
    }

    @Override
    public SortingNumber[] sort(SortingNumber[] data) {
        boolean finished = false;
        while(!finished){
            int n = data.length;
            finished=true;
            for(int i = 0; i < n-1; i++){
                if(data[i].getSortingValue()>data[i+1].getSortingValue()){
                    finished=false;
                    SortingNumber temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                }
            }
        }
        return data;
    }
}
