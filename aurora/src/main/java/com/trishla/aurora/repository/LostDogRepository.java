package com.trishla.aurora.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trishla.aurora.dtos.LostDog;
import com.trishla.aurora.dtos.requests.SearchDogsRequest;

@Component
public interface LostDogRepository{
    void create(LostDog obj);

    LostDog read(String id);

    List<LostDog> readAll();

    void update(LostDog obj);

    LostDog delete(String id);

    List<LostDog> search(SearchDogsRequest request);
}
