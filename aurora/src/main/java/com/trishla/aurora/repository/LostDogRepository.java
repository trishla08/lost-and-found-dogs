package com.trishla.aurora.repository;

import java.util.List;

import com.trishla.aurora.dtos.LostDog;

public interface LostDogRepository {
    void create(LostDog obj);

    LostDog read(String id);

    List<LostDog> readAll();

    void update(LostDog obj);

    LostDog delete(String id);
}
