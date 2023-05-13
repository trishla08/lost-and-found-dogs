package com.trishla.aurora.post.lostDog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.trishla.aurora.post.lostDog.dao.LostDogPostDao;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;
import com.trishla.aurora.post.lostDog.repository.DaoTransformer;
import com.trishla.aurora.post.lostDog.repository.LostDogPostJpaRepository;

public class LostDogPostOperations {
    private LostDogPostJpaRepository repo;
    private DaoTransformer transformer;

    
    public LostDogPostOperations(LostDogPostJpaRepository repo, DaoTransformer transformer) {
        this.repo = repo;
        this.transformer = transformer;
    }

    LostDogPost createPost(LostDogPost post) {
        return transformer.convertToDto(repo.save(transformer.convertToDao(post)));
    };

    Optional<LostDogPost> getPost(Long UID) {
        return repo.findById(UID)
        .map(transformer::convertToDto);
    };

    List<LostDogPost> getPostsForUser(Long UID) {
        // TODO: implement
        return new ArrayList<>();
    };

    LostDogPost updatePost(LostDogPost user) {
        Optional<LostDogPostDao> optionalPostDao = repo.findById(user.getUID());
        if (optionalPostDao.isEmpty()) {
            return null;
        }
        LostDogPostDao updatedDao = mergeInFields(optionalPostDao.get(), user);

        return transformer.convertToDto(repo.save(updatedDao));
    };

    void deletePost(Long UID) {
        repo.deleteById(UID);
    };


    private LostDogPostDao mergeInFields(LostDogPostDao oldDao, LostDogPost fieldsToUpdate) {
        // TODO: implement
        return null;
    }
}
