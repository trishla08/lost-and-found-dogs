package com.trishla.aurora.utils;

import lombok.Getter;

@Getter
public class BoundingBox {
    double minLat;
    double maxLat;
    double minLon;
    double maxLon;

    public BoundingBox(double minLat, double maxLat, double minLon, double maxLon) {
        this.minLat = minLat;
        this.maxLat = maxLat;
        this.minLon = minLon;
        this.maxLon = maxLon;
    }

    public boolean contains(Point p) {
        return ((minLat <= p.getLatitude() && p.getLatitude() <= maxLat)
                && (minLon <= p.getLongitude() && p.getLongitude() <= maxLon));
    }
}
