package com.trishla.aurora.post.foundDog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.post.foundDog.service.FoundDogPostMatcher;
import com.trishla.aurora.post.foundDog.service.FoundDogPostOperations;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class FoundDogController {

    @Autowired
    FoundDogPostOperations foundDogPostOperations;

    @Autowired
    FoundDogPostMatcher foundDogPostMatcher;

    @PostMapping(value = "/v1/dog/found")
    public FoundDogPost addFoundDogPost(@RequestBody FoundDogPost foundDogPost) {
        return foundDogPostOperations.createPost(foundDogPost);
    }

    @GetMapping("/v1/dog/found/{id}")
    public FoundDogPost getFoundDogPostDetails(@PathVariable Long id) {
        Optional<FoundDogPost> optPost = foundDogPostOperations.getPost(id);
        if (optPost.isPresent()) {
            return optPost.get();
        }
        return null;
    }

    @PutMapping("/v1/dog/found/{id}")
    public FoundDogPost updateFound(@RequestBody FoundDogPost foundDogPost) {
        return foundDogPostOperations.updatePost(foundDogPost);
    }

    @DeleteMapping("/v1/dog/found/{id}")
    public void deleteFound(@PathVariable Long id) {
        foundDogPostOperations.deletePost(id);
    }

    @GetMapping("/v1/dog/found/{id}/matches")
    public List<LostDogPost> getOrderedMatchingLostDogPosts(@PathVariable Long id) {
        List<LostDogPost> resultList = foundDogPostMatcher.getOrderedMatchingLostDogPosts(id);
        return resultList;
    }
}
