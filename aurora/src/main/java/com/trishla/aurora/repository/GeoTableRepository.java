package com.trishla.aurora.repository;

import java.util.List;

import com.trishla.aurora.dtos.Geohash;

public interface GeoTableRepository {
    void create(Geohash obj);

    Geohash read(String id);

    List<Geohash> readAll();

    void update(Geohash obj);

    Geohash delete(Geohash id);

    List<Geohash> getNearestPoints(String geoHash, int precision);
}
