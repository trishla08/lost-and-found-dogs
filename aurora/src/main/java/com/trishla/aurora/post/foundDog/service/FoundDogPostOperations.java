package com.trishla.aurora.post.foundDog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.trishla.aurora.post.foundDog.dao.FoundDogPostDao;
import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.post.foundDog.repository.DaoTransformer;
import com.trishla.aurora.post.foundDog.repository.FoundDogPostJpaRepository;

public class FoundDogPostOperations {
    private FoundDogPostJpaRepository repo;
    private DaoTransformer transformer;

    public FoundDogPostOperations(FoundDogPostJpaRepository repo, DaoTransformer transformer) {
        this.repo = repo;
        this.transformer = transformer;
    }

    FoundDogPost createPost(FoundDogPost post) {
        return transformer.convertToDto(repo.save(transformer.convertToDao(post)));
    };

    Optional<FoundDogPost> getPost(Long UID) {
        return repo.findById(UID)
            .map(transformer::convertToDto);
    }

    List<FoundDogPost> getPostsForUser(Long userUID) {
        // TODO: implement
        return new ArrayList<>();
    };

    FoundDogPost updatePost(FoundDogPost user) {
        Optional<FoundDogPostDao> optionalPostDao = repo.findById(user.getUID());
        if (optionalPostDao.isEmpty()) {
            return null;
        }
        FoundDogPostDao updatedDao = mergeInFields(optionalPostDao.get(), user);

        return transformer.convertToDto(repo.save(updatedDao));
    };


    void deletePost(Long UID) {
        repo.deleteById(UID);
    };

    private FoundDogPostDao mergeInFields(FoundDogPostDao oldDao, FoundDogPost fieldsToUpdate) {
        // TODO: implement
        return null;
    }
}
