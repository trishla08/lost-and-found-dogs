package com.trishla.aurora.post.lostDog.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trishla.aurora.post.lostDog.dao.LostDogPostDao;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;
import com.trishla.aurora.post.lostDog.repository.LostDogDaoTransformer;
import com.trishla.aurora.post.lostDog.repository.LostDogPostJpaRepository;
import com.trishla.aurora.user.dao.UserDao;
import com.trishla.aurora.user.repository.UserJpaRepository;

@Service
public class LostDogPostOperations {
    private LostDogPostJpaRepository repo;
    private LostDogDaoTransformer transformer;
    private UserJpaRepository userRepo;

    public LostDogPostOperations(LostDogPostJpaRepository repo, LostDogDaoTransformer transformer, UserJpaRepository userRepo) {
        this.repo = repo;
        this.transformer = transformer;
        this.userRepo = userRepo;
    }

    public LostDogPost createPost(LostDogPost post) {
        UserDao userDao = userRepo.getReferenceById(post.getUser().getUID());
        LostDogPostDao lostDogPostDao = transformer.convertToDao(post);
        lostDogPostDao.setUser(userDao);
        return transformer.convertToDto(repo.save(lostDogPostDao));
    };

    public Optional<LostDogPost> getPost(Long UID) {
        return repo.findById(UID)
                .map(transformer::convertToDto);
    };

    public LostDogPost updatePost(LostDogPost lostDogPost) {
        Optional<LostDogPostDao> optionalPostDao = repo.findById(lostDogPost.getUID());
        if (optionalPostDao.isEmpty()) {
            return null;
        }
        UserDao userDao = userRepo.getReferenceById(lostDogPost.getUser().getUID());
        LostDogPostDao lostDogPostDao = transformer.convertToDao(lostDogPost);
        lostDogPostDao.setUser(userDao);
        return transformer.convertToDto(repo.save(lostDogPostDao));
    };

    public void deletePost(Long UID) {
        repo.deleteById(UID);
    };
}
