package com.trishla.aurora.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.requests.SearchDogsRequest;

@Component
public interface FoundDogRepository {
    void create(FoundDog obj);

    FoundDog read(String id);

    List<FoundDog> readAll();

    void update(FoundDog obj);

    FoundDog delete(String id);

    List<FoundDog> search(SearchDogsRequest request);
}
