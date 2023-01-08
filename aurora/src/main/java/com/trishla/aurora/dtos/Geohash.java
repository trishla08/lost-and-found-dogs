package com.trishla.aurora.dtos;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import ch.hsr.geohash.GeoHash;
import lombok.Getter;

@Getter
public class Geohash {
    private final String uid;
    private final Point point;
    private final ImmutableMap<Integer, String> geoHashes;

    private static final int minPrecision = 3;
    private static final int maxPrecision = 6;

    public Geohash(String uid, Point point) {
        this.uid = uid;
        this.point = point;
        this.geoHashes = ImmutableMap.copyOf(getGeohashesForPoint(point));
    }

    private Map<Integer, String> getGeohashesForPoint(Point p) {
        HashMap<Integer, String> map = new HashMap<Integer, String>(); 
        for (int precision = minPrecision; precision <= maxPrecision; precision++) {
            map.put(precision,
                    GeoHash.geoHashStringWithCharacterPrecision(p.getLatitude(), p.getLongitude(), precision));
        }
        return map;
    }
}
