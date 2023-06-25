package com.trishla.aurora.post.foundDog.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trishla.aurora.post.common.service.DogPostsScoringAlgorithm;
import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;
import com.trishla.aurora.post.lostDog.service.LostDogPostOperations;

@Service
public class FoundDogPostMatcher {

    @Autowired
    LostDogPostOperations lostDogPostOperations;

    @Autowired
    FoundDogPostOperations foundDogPostOperations;

    public List<LostDogPost> getOrderedMatchingLostDogPosts(Long id) {
        List<LostDogPost> allLostDogPosts = lostDogPostOperations.getAllLostDogPosts();
        FoundDogPost foundDogPost = foundDogPostOperations.getPost(id).get();

        // Create a list to store the scores for each pair
        List<Integer> scores = new ArrayList<>();

        // Calculate the score for each pair of LostDogPost and FoundDogPost
        DogPostsScoringAlgorithm scoringAlgorithm = new DogPostsScoringAlgorithm();
        for (LostDogPost lostDogPost : allLostDogPosts) {
            int score = scoringAlgorithm.findScoreForPair(lostDogPost, foundDogPost);
            scores.add(score);
        }

        // Sort the allLostDogPosts list based on the descending value of scores
        Collections.sort(allLostDogPosts, Collections
                .reverseOrder(Comparator.comparingInt((LostDogPost ldp) -> scores.get(allLostDogPosts.indexOf(ldp)))));

        return allLostDogPosts;
    }
}
