package com.trishla.aurora.post.lostDog.controller;

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
import com.trishla.aurora.post.lostDog.dto.LostDogPost;
import com.trishla.aurora.post.lostDog.service.LostDogPostMatcher;
import com.trishla.aurora.post.lostDog.service.LostDogPostOperations;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
public class LostDogController {

    @Autowired
    LostDogPostOperations lostDogPostOperations;

    @Autowired
    LostDogPostMatcher lostDogPostMatcher;

    @PostMapping(value = "/v1/dog/lost")
    public LostDogPost addLostDog(@RequestBody LostDogPost lostDogPost) {
        return lostDogPostOperations.createPost(lostDogPost);
    }

    @GetMapping("/v1/dog/lost/{id}")
    public LostDogPost getLostDogPostDetails(@PathVariable Long id) {
        Optional<LostDogPost> optPost = lostDogPostOperations.getPost(id);
        if (optPost.isPresent()) {
            return optPost.get();
        }
        return null;
    }

    @PutMapping("/v1/dog/lost/{id}")
    public LostDogPost updateLost(@RequestBody LostDogPost lostDogPost) {
        return lostDogPostOperations.updatePost(lostDogPost);
    }

    @DeleteMapping("/v1/dog/lost/{id}")
    public void deleteLost(@PathVariable Long id) {
        lostDogPostOperations.deletePost(id);
    }

    @GetMapping("/v1/dog/lost/{id}/matches")
    public List<FoundDogPost> getOrderedMatchingFoundDogPosts(@PathVariable Long id) {
        List<FoundDogPost> resultList = lostDogPostMatcher.getOrderedMatchingFoundDogPosts(id);
        return resultList;
    }
}
