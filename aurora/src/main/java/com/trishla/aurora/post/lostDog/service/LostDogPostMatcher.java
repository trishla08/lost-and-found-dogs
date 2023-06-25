package com.trishla.aurora.post.lostDog.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trishla.aurora.post.common.service.DogPostsScoringAlgorithm;
import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.post.foundDog.service.FoundDogPostOperations;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;

@Service
public class LostDogPostMatcher {

    @Autowired
    LostDogPostOperations lostDogPostOperations;

    @Autowired
    FoundDogPostOperations foundDogPostOperations;

    public List<FoundDogPost> getOrderedMatchingFoundDogPosts(Long id) {
        List<FoundDogPost> allFoundDogPosts = foundDogPostOperations.getAllFoundDogPosts();
        LostDogPost lostDogPost = lostDogPostOperations.getPost(id).get();

        // Create a list to store the scores for each pair
        List<Integer> scores = new ArrayList<>();

        // Calculate the score for each pair of LostDogPost and FoundDogPost
        DogPostsScoringAlgorithm scoringAlgorithm = new DogPostsScoringAlgorithm();
        for (FoundDogPost foundDogPost : allFoundDogPosts) {
            int score = scoringAlgorithm.findScoreForPair(lostDogPost, foundDogPost);
            scores.add(score);
        }

        // Sort the allLostDogPosts list based on the descending value of scores
        Collections.sort(allFoundDogPosts, Collections
                .reverseOrder(Comparator.comparingInt((FoundDogPost ldp) -> scores.get(allFoundDogPosts.indexOf(ldp)))));

        return allFoundDogPosts;
    }
}
