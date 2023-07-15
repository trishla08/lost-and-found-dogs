package com.trishla.aurora.user.repository;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;

import org.mindrot.jbcrypt.BCrypt;
import com.trishla.aurora.post.foundDog.dao.FoundDogPostDao;
import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.post.foundDog.repository.FoundDogDaoTransformer;
import com.trishla.aurora.post.lostDog.dao.LostDogPostDao;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;
import com.trishla.aurora.post.lostDog.repository.LostDogDaoTransformer;
import com.trishla.aurora.user.dao.UserDao;
import com.trishla.aurora.user.dto.User;
import com.trishla.aurora.user.service.UserPasswordGenerator;

@Service
public class UserDaoTransformer {

    LostDogDaoTransformer lostDogDaoTransformer = new LostDogDaoTransformer();
    FoundDogDaoTransformer foundDogDaoTransformer = new FoundDogDaoTransformer();
    int length = 16;

    public UserDao convertToDao(User user) {
        UserDao.UserDaoBuilder userDao = UserDao.builder();
        userDao.UID(user.getUID())
                .name(user.getName())
                .emailAddress(user.getEmailAddress())
                .contactNumber(user.getContactNumber());

        String salt = UserPasswordGenerator.generateSalt(length);
        String hashedPassword = UserPasswordGenerator.hashPassword(user.getPassword(), salt);

        userDao.passwordHash(hashedPassword).passwordSalt(salt);

        List<LostDogPostDao> convertedLostDogPosts = new ArrayList<>();
        if (user.getLostDogPosts() != null) {
            for (LostDogPost lostDogPost : user.getLostDogPosts()) {
                LostDogPostDao convertedLostDogPost = lostDogDaoTransformer.convertToDao(lostDogPost);
                convertedLostDogPosts.add(convertedLostDogPost);
            }
        }
        List<FoundDogPostDao> convertedFoundDogPosts = new ArrayList<>();
        if (user.getFoundDogPosts() != null) {
            for (FoundDogPost foundDogPost : user.getFoundDogPosts()) {
                FoundDogPostDao convertedFoundDogPost = foundDogDaoTransformer.convertToDao(foundDogPost);
                convertedFoundDogPosts.add(convertedFoundDogPost);
            }
        }

        return userDao.lostDogPosts(convertedLostDogPosts).foundDogPosts(convertedFoundDogPosts).build();
    }

    public User convertToDto(UserDao userDao) {
        User.UserBuilder user = User.builder();
        user.UID(userDao.getUID())
                .name(userDao.getName())
                .emailAddress(userDao.getEmailAddress())
                .contactNumber(userDao.getContactNumber())
                .passwordHash(userDao.getPasswordHash())
                .passwordSalt(userDao.getPasswordSalt()).build();

        List<LostDogPost> convertedLostDogPosts = new ArrayList<>();
        if (userDao.getLostDogPosts() != null) {
            for (LostDogPostDao lostDogPost : userDao.getLostDogPosts()) {
                LostDogPost convertedLostDogPost = lostDogDaoTransformer.convertToDto(lostDogPost);
                convertedLostDogPosts.add(convertedLostDogPost);
            }
        }

        List<FoundDogPost> convertedFoundDogPosts = new ArrayList<>();
        if (userDao.getFoundDogPosts() != null) {
            for (FoundDogPostDao foundDogPost : userDao.getFoundDogPosts()) {
                FoundDogPost convertedFoundDogPost = foundDogDaoTransformer.convertToDto(foundDogPost);
                convertedFoundDogPosts.add(convertedFoundDogPost);
            }
        }
        return user.lostDogPosts(convertedLostDogPosts).foundDogPosts(convertedFoundDogPosts).build();
    }
}
