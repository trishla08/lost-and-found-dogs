package com.trishla.aurora.repository;

import java.util.List;

import com.trishla.aurora.dtos.GeoTableEntry;

public class GeoTableRealRepository implements GeoTableRepository {

    @Override
    public void create(GeoTableEntry obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public GeoTableEntry delete(GeoTableEntry id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GeoTableEntry read(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<GeoTableEntry> readAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(GeoTableEntry obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<GeoTableEntry> getNearestPoints(String geoHash, int precision) {
        // TODO Auto-generated method stub
        return null;
    }
}
