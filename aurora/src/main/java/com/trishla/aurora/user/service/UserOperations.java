package com.trishla.aurora.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trishla.aurora.user.dao.UserDao;
import com.trishla.aurora.user.dto.LoginRequest;
import com.trishla.aurora.user.dto.User;
import com.trishla.aurora.user.repository.UserDaoTransformer;
import com.trishla.aurora.user.repository.UserJpaRepository;

@Service
public class UserOperations {

    private UserJpaRepository repo;
    private UserDaoTransformer transformer;

    public UserOperations(UserJpaRepository repo, UserDaoTransformer transformer) {
        this.repo = repo;
        this.transformer = transformer;
    }

    public User createUser(User user) {
        return transformer.convertToDto(repo.save(transformer.convertToDao(user)));
    }

    public Optional<User> getUser(String UID) {
        return repo.findById(UID)
                .map(transformer::convertToDto);
    };

    public User updateUser(User user) {
        Optional<UserDao> optionalUser = repo.findById(user.getUID());
        if (optionalUser.isEmpty()) {
            return null;
        }
        return transformer.convertToDto(repo.save(transformer.convertToDao(user)));
    };

    public void deleteUser(String UID) {
        repo.deleteById(UID);
    };

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        for (UserDao userDao : repo.findAll()) {
            usersList.add(transformer.convertToDto(userDao));
        }
        return usersList;
    }

    public User fetchUserByEmailAddress(String emailAddress) {
        return transformer.convertToDto(repo.findByEmailAddress(emailAddress));
    }

    public Boolean validateCredentials(LoginRequest loginRequest, User user) {
        String userSalt = user.getPasswordSalt();
        String userHash = user.getPasswordHash();

        String enteredPasswordHash = UserPasswordGenerator.hashPassword(loginRequest.getPassword(), userSalt);

        return enteredPasswordHash.equals(userHash);
    }
}
