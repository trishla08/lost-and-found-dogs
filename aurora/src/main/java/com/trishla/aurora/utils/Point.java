package com.trishla.aurora.utils;

import lombok.Getter;

@Getter
public class Point {
    double latitude;
    double longitude;
    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
