package com.trishla.aurora.new_db;

import com.trishla.aurora.new_dtos.User;

public interface UserRepository {
    User createUser(User user);
    User getUser(Long UID);
    User updateUser(User user);
    void deleteUser(Long UID);
}