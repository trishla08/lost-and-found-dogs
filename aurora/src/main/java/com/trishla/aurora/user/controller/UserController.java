package com.trishla.aurora.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;
import com.trishla.aurora.user.dto.User;
import com.trishla.aurora.user.service.UserOperations;

@RestController
public class UserController {

    @Autowired
    UserOperations userOperations;

    @PostMapping(value = "/v1/user")
    public User addUser(@RequestBody User user) {
        return userOperations.createUser(user);
    }

    @GetMapping("/v1/user/{id}")
    public User getUserDetails(@PathVariable Long id) {
        Optional<User> optUser =  userOperations.getUser(id);
        if (optUser.isPresent()){
            return optUser.get();
        }
        return null;
    }

    @GetMapping("/v1/user/{id}/posts/lost")
    public List<LostDogPost> getAllLostDogPostsForUser(@PathVariable Long id) {
        Optional<User> optUser =  userOperations.getUser(id);
        if (optUser.isPresent()){
            return optUser.get().getLostDogPosts();
        }
        return null;
    }

    @GetMapping("/v1/user/{id}/posts/found")
    public List<FoundDogPost> getAllFoundDogPostsForUser(@PathVariable Long id) {
        Optional<User> optUser =  userOperations.getUser(id);
        if (optUser.isPresent()){
            return optUser.get().getFoundDogPosts();
        }
        return null;
    }

    @PutMapping("/v1/user/{id}")
    public User updateUser(@RequestBody User user) {
        return userOperations.updateUser(user);
    }

    @DeleteMapping("/v1/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userOperations.deleteUser(id);
    }

    @GetMapping("/v1/users/all")
    public List<User> showAllUsers() {
        return userOperations.getAllUsers();
    }
}
