package com.trishla.aurora.user.service;

import com.trishla.aurora.user.dto.User;

public class UserOperations {
    User createUser(User user) {
        // save query
        return user;
    }

    User getUser(Long UID) {
      //  return FoundDogJpaRepository.findById(id).get();
      return User.builder().build();
    };

    User updateUser(User user) {
        return User.builder().build();
    }

    void deleteUser(Long UID) {
        
    }
    
}
