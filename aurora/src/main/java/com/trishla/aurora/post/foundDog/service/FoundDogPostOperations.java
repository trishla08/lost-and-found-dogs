package com.trishla.aurora.post.foundDog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trishla.aurora.post.foundDog.dao.FoundDogPostDao;
import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.post.foundDog.repository.FoundDogDaoTransformer;
import com.trishla.aurora.post.foundDog.repository.FoundDogPostJpaRepository;
import com.trishla.aurora.user.dao.UserDao;
import com.trishla.aurora.user.repository.UserJpaRepository;

@Service
public class FoundDogPostOperations {
    private FoundDogPostJpaRepository repo;
    private FoundDogDaoTransformer transformer;
    private UserJpaRepository userRepo;

    public FoundDogPostOperations(FoundDogPostJpaRepository repo, FoundDogDaoTransformer transformer, UserJpaRepository userRepo) {
        this.repo = repo;
        this.transformer = transformer;
        this.userRepo = userRepo;
    }

    public FoundDogPost createPost(FoundDogPost post) {
        UserDao userDao = userRepo.getReferenceById(post.getUser().getUID());
        FoundDogPostDao foundDogPostDao = transformer.convertToDao(post);
        foundDogPostDao.setUser(userDao);
        return transformer.convertToDto(repo.save(foundDogPostDao));
    };

    public Optional<FoundDogPost> getPost(Long UID) {
        return repo.findById(UID)
            .map(transformer::convertToDto);
    }

    public FoundDogPost updatePost(FoundDogPost foundDogPost) {
        Optional<FoundDogPostDao> optionalPostDao = repo.findById(foundDogPost.getUID());
        if (optionalPostDao.isEmpty()) {
            return null;
        }
        UserDao userDao = userRepo.getReferenceById(foundDogPost.getUser().getUID());
        FoundDogPostDao foundDogPostDao = transformer.convertToDao(foundDogPost);
        foundDogPostDao.setUser(userDao);
        return transformer.convertToDto(repo.save(foundDogPostDao));
    };

    public void deletePost(Long UID) {
        repo.deleteById(UID);
    };

    public List<FoundDogPost> getAllFoundDogPosts() {
        List<FoundDogPostDao> foundDogPostDaoList = repo.findAll();
        List<FoundDogPost> foundDogPostList = new ArrayList<>();
        for (FoundDogPostDao postDao: foundDogPostDaoList) {
            foundDogPostList.add(transformer.convertToDto(postDao));
        }
        return foundDogPostList;
    }
}
