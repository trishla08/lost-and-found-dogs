package com.trishla.aurora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trishla.aurora.dtos.FoundDog;

public interface FoundDogJpaRepositoryInterface extends JpaRepository<FoundDog, String> {
}
