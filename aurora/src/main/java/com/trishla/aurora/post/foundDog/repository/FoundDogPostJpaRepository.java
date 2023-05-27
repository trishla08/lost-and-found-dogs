package com.trishla.aurora.post.foundDog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trishla.aurora.post.foundDog.dao.FoundDogPostDao;

public interface FoundDogPostJpaRepository extends JpaRepository<FoundDogPostDao, Long> {
}