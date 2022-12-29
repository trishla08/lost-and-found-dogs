package com.trishla.aurora.dtos;

import lombok.Getter;

@Getter
public class UidsAndDistances {
    String uid;
    double distance;

    public UidsAndDistances(String uid, double distance) {
        this.uid = uid;
        this.distance = distance;
    }
}
