package com.tutorial.sortalg.model.algorithm;

import com.tutorial.sortalg.model.SortingNumber;

import java.util.Random;

public class QuickSort implements SortingAlgorithm {
    @Override
    public String getAlgorithm() {
        return "Quick Sort";
    }

    @Override
    public SortingNumber[] sort(SortingNumber[] data) {
        quickSort(data, 0, data.length-1);
        return data;
    }

    private void quickSort(SortingNumber[] data, int startIndex, int endIndex) {
        if(endIndex<=startIndex){
            return;
        }

        int partitionIndex = partition(data, startIndex, endIndex);
        quickSort(data, startIndex, partitionIndex-1);
        quickSort(data, partitionIndex+1, endIndex);
    }

    private int partition(SortingNumber[] data, int startIndex, int endIndex) {
        int pivotIndex = startIndex + new Random().nextInt(endIndex - startIndex);
        swap(data, pivotIndex, endIndex);

        int prev = startIndex-1;
        for(int i = startIndex; i < endIndex; i++){
            if(data[i].getSortingValue()<data[endIndex].getSortingValue()){
                prev++;
                swap(data, prev, i);
            }
        }

        swap(data, prev+1, endIndex);

        return prev+1;
    }

    private void swap(SortingNumber[] arr, int index1, int index2) {
        SortingNumber temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

}
