package com.trishla.aurora.post.lostDog.repository;

import java.util.Optional;

import com.trishla.aurora.post.lostDog.dao.LostDogDao;
import com.trishla.aurora.post.lostDog.dao.LostDogPostDao;
import com.trishla.aurora.post.lostDog.dto.LostDog;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;

public class DaoTransformer {
    public LostDogPostDao convertToDao(LostDogPost lostDogPost) {
        LostDogPostDao.LostDogPostDaoBuilder lostDogPostDao = LostDogPostDao.builder();
        return lostDogPostDao.lostDog(convertLostDogToDao(lostDogPost.getLostDog()))
                .postCreationTimestamp(lostDogPost.getPostCreationTimestamp())
                .postStatus(lostDogPost.getPostStatus())
                .title(lostDogPost.getTitle())
                .userID(lostDogPost.getUserID()).build();
    }

    private LostDogDao convertLostDogToDao(LostDog lostDog) {
        LostDogDao.LostDogDaoBuilder lostDogDaoBuilder = LostDogDao.builder();
        return lostDogDaoBuilder.age(lostDog.getAge()).breed(lostDog.getBreed()).dateLost(lostDog.getDateLost())
                .distinctiveFeatures(lostDog.getDistinctiveFeatures())
                .gender(lostDog.getGender())
                .lastKnownLocation(lostDog.getLastKnownLocation())
                .message(lostDog.getMessage())
                .ownerEmail(lostDog.getOwnerEmail())
                .ownerName(lostDog.getOwnerName())
                .ownerPhone(lostDog.getOwnerPhone())
                .photo(lostDog.getPhoto())
                .build();
    }

    public LostDogPost convertToDtoOptional(Optional<LostDogPostDao> lostDogPost) {
        return null;
    }

    public LostDogPost convertToDto(LostDogPostDao lostDogPost) {
        return null;
    }
}
