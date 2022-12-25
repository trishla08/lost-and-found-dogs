package com.trishla.aurora.utils;

import java.util.Comparator;

import com.trishla.aurora.dtos.UidsAndDistances;

public class UidDistanceCustomComparator implements Comparator<UidsAndDistances> {
    @Override
    public int compare(UidsAndDistances object1, UidsAndDistances object2) {
        return (int) (object1.getDistance() - object2.getDistance());
    }
}