package com.trishla.aurora.dtos;

public class UidsAndDistances {
    String uid;
    double distance;

    public UidsAndDistances(String uid, double distance) {
        this.uid = uid;
        this.distance = distance;
    }

    public String getUid() {
        return uid;
    }

    public double getDistance() {
        return distance;
    }
}