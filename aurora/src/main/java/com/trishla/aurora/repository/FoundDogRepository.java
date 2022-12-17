package com.trishla.aurora.repository;

import java.util.List;

import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.requests.SearchDogsRequest;

public interface FoundDogRepository {
    void create(FoundDog obj);

    FoundDog read(String id);

    List<FoundDog> readAll();

    void update(FoundDog obj);

    FoundDog delete(String id);

    List<FoundDog> search(SearchDogsRequest request);
}
