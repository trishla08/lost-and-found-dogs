package com.trishla.aurora.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.trishla.aurora.dtos.GeoTableEntry;
import com.trishla.aurora.dtos.UidsAndDistances;
import com.trishla.aurora.repository.GeoTableRealRepository;
import com.trishla.aurora.repository.GeoTableRepository;

import ch.hsr.geohash.GeoHash;

public class PointSearch {
    private static final double EARTH_RADIUS = 6371.0; // radius of the earth in kilometers

    static GeoTableRepository repository = new GeoTableRealRepository(); 

    public static List<String> search(Point center, double radius) {
        int prec = getPrecisionForRadius(radius);
        String geoHashForCenter = GeoHash.geoHashStringWithCharacterPrecision(center.getLatitude(),
                center.getLongitude(), prec);
        // search in geotable for prefix accordingly
        List<GeoTableEntry> nearestPoints = repository.getNearestPoints(geoHashForCenter, prec);
        return sortAndGetUids(nearestPoints, center);
    }

    private static List<String> sortAndGetUids(List<GeoTableEntry> geoTables, Point center) {
       List<UidsAndDistances> uidsAndDistances = new ArrayList<>();
       for (GeoTableEntry entry: geoTables) {
        uidsAndDistances.add(new UidsAndDistances(entry.getUid(), getDistance(center, entry.getPoint())));
       }
       Collections.sort(uidsAndDistances, new UidDistanceCustomComparator());
       List<String> uids = new ArrayList<>();
       for (UidsAndDistances entry: uidsAndDistances) {
        uids.add(entry.getUid());
       }
       return uids;
    }

    private static Integer getPrecisionForRadius(double radius) {
        if (radius <= 0.5) {
            return 6;
        } else if (radius <= 1.2) {
            return 5;
        } else if (radius <= 10) {
            return 4;
        } 
        return 3;
    }

    private static double getDistance(Point p1, Point p2) {
        // convert the latitude and longitude of the points to radians
        double lat1 = Math.toRadians(p1.getLatitude());
        double lon1 = Math.toRadians(p1.getLongitude());
        double lat2 = Math.toRadians(p2.getLatitude());
        double lon2 = Math.toRadians(p2.getLongitude());

        // calculate the distance between the points using the Haversine formula
        double a = Math.sin((lat2 - lat1) / 2) * Math.sin((lat2 - lat1) / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin((lon2 - lon1) / 2) * Math.sin((lon2 - lon1) / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}

