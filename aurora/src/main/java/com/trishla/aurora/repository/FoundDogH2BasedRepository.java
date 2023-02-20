package com.trishla.aurora.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.requests.SearchDogsRequest;

@Component
public class FoundDogH2BasedRepository implements FoundDogRepository {

    @Autowired
	private FoundDogJpaRepositoryInterface FoundDogJpaRepository;

    @Override
    public void create(FoundDog obj) {
        FoundDogJpaRepository.save(obj);
    }

    @Override
    public FoundDog read(String id) {
        return FoundDogJpaRepository.findById(id).get();
    }

    @Override
    public List<FoundDog> readAll() {
        return FoundDogJpaRepository.findAll();
    }

    @Override
    public void update(FoundDog obj) {
        FoundDogJpaRepository.delete(obj);
        FoundDogJpaRepository.save(obj);
    }

    @Override
    public FoundDog delete(String id) {
        FoundDog foundDog = FoundDogJpaRepository.findById(id).get();
        FoundDogJpaRepository.deleteById(id);
        return foundDog;
    }

    @Override
    public List<FoundDog> search(SearchDogsRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
