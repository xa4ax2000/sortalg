package com.tutorial.sortalg.model.algorithm;

import com.tutorial.sortalg.model.SortingNumber;

public class RecursiveInsertionSort implements SortingAlgorithm {
    @Override
    public String getAlgorithm() {
        return "Recursive Insertion Sort";
    }

    @Override
    public SortingNumber[] sort(SortingNumber[] data) {
        sort(data, data.length);
        return data;
    }

    // 3,7,1,5
    private void sort(SortingNumber[] data, int sizeOfUnsortedArray){
        if(sizeOfUnsortedArray<=1){
            return;
        }

        sort(data, sizeOfUnsortedArray-1);

        SortingNumber temp = data[sizeOfUnsortedArray-1];
        int i = sizeOfUnsortedArray-2;
        while(i>=0 && temp.getSortingValue() < data[i].getSortingValue()){
            data[i+1] = data[i];
            i--;
        }
        data[i+1] = temp;
    }
}
