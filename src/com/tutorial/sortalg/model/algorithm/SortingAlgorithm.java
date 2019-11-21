package com.tutorial.sortalg.model.algorithm;

import com.tutorial.sortalg.model.SortingNumber;

import java.util.List;

public interface SortingAlgorithm {
    String getAlgorithm();
    SortingNumber[] sort(SortingNumber[] data);
}
