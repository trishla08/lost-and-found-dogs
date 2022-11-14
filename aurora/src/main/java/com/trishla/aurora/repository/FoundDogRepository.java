package com.trishla.aurora.repository;

import java.util.List;

import com.trishla.aurora.dtos.FoundDog;

public interface FoundDogRepository {
    void create(FoundDog obj);

    FoundDog read(String id);

    List<FoundDog> readAll();

    void update(FoundDog obj);

    void delete(String id);
}