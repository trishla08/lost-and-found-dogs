package com.trishla.aurora.repository;

import java.util.List;

import com.trishla.aurora.dtos.GeoTable;

public interface GeoTableRepository {
    void create(GeoTable obj);

    GeoTable read(String id);

    List<GeoTable> readAll();

    void update(GeoTable obj);

    GeoTable delete(GeoTable id);
}
