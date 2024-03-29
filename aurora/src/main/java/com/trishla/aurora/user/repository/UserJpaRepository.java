package com.trishla.aurora.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trishla.aurora.user.dao.UserDao;

public interface UserJpaRepository extends JpaRepository<UserDao, String> {
    UserDao findByEmailAddress(String emailAddress);
}