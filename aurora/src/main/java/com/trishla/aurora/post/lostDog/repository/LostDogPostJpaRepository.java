package com.trishla.aurora.post.lostDog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trishla.aurora.post.lostDog.dao.LostDogPostDao;

public interface LostDogPostJpaRepository extends JpaRepository<LostDogPostDao, Long> {}