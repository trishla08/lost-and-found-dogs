package com.trishla.aurora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trishla.aurora.dtos.LostDog;

public interface LostDogJpaRepository extends JpaRepository<LostDog, String> {
}
