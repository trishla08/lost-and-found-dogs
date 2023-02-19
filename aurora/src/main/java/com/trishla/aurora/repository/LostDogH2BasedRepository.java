package com.trishla.aurora.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trishla.aurora.dtos.LostDog;
import com.trishla.aurora.dtos.requests.SearchDogsRequest;

@Component
public class LostDogH2BasedRepository implements LostDogRepository {

    @Autowired
	private LostDogJpaRepository lostDogJpaRepository;

    @Override
    public void create(LostDog obj) {
        lostDogJpaRepository.save(obj);
    }

    @Override
    public LostDog read(String id) {
        return lostDogJpaRepository.findById(id).get();
    }

    @Override
    public List<LostDog> readAll() {
        return lostDogJpaRepository.findAll();
    }

    @Override
    public void update(LostDog obj) {
        lostDogJpaRepository.delete(obj);
        lostDogJpaRepository.save(obj);
    }

    @Override
    public LostDog delete(String id) {
        LostDog lostDog = lostDogJpaRepository.findById(id).get();
        lostDogJpaRepository.deleteById(id);
        return lostDog;
    }

    @Override
    public List<LostDog> search(SearchDogsRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
