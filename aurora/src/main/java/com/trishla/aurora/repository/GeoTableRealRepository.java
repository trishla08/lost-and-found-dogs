package com.trishla.aurora.repository;

import java.util.List;

import com.trishla.aurora.dtos.Geohash;

public class GeoTableRealRepository implements GeoTableRepository {

    @Override
    public void create(Geohash obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public Geohash delete(Geohash id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Geohash read(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Geohash> readAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Geohash obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Geohash> getNearestPoints(String geoHash, int precision) {
        // TODO Auto-generated method stub
        return null;
    }
}
