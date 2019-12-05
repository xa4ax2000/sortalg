package com.tutorial.sortalg.model.algorithm;

import com.tutorial.sortalg.model.SortingNumber;

import java.util.Hashtable;

public class MergeSort implements SortingAlgorithm {
    @Override
    public String getAlgorithm() {
        return "Merge Sort";
    }

    // 5, 2, 7 , 1, 3
    @Override
    public SortingNumber[] sort(SortingNumber[] data) {
        splitAndMerge(data, 0, data.length-1);
        return data;
    }

    private void splitAndMerge(SortingNumber[] data, int startIndex, int endIndex){
        if(endIndex<=startIndex){
            return;
        }

        int middleIndex = (endIndex+startIndex)/2;
        splitAndMerge(data, startIndex, middleIndex);
        splitAndMerge(data, middleIndex+1, endIndex);

        SortingNumber[] leftArr = new SortingNumber[middleIndex-startIndex+1];
        System.arraycopy(data, startIndex, leftArr, 0, middleIndex-startIndex+1);
        SortingNumber[] rightArr = new SortingNumber[endIndex-middleIndex];
        System.arraycopy(data, middleIndex+1, rightArr, 0, endIndex-middleIndex);

        int i = 0, j = 0, k = startIndex;
        while(i<leftArr.length && j<rightArr.length){
            if(leftArr[i].getSortingValue() <= rightArr[j].getSortingValue()){
                data[k] = leftArr[i];
                i++;
            }
            else{
                data[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i<leftArr.length){
            data[k] = leftArr[i];
            i++;
            k++;
        }

        while(j<rightArr.length){
            data[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
