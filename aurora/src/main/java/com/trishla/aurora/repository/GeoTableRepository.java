package com.trishla.aurora.repository;

import java.util.List;

import com.trishla.aurora.dtos.GeoTableEntry;

public interface GeoTableRepository {
    void create(GeoTableEntry obj);

    GeoTableEntry read(String id);

    List<GeoTableEntry> readAll();

    void update(GeoTableEntry obj);

    GeoTableEntry delete(GeoTableEntry id);

    List<GeoTableEntry> getNearestPoints(String geoHash, int precision);
}
