package com.trishla.aurora.user.dto;

import java.util.List;

import com.trishla.aurora.post.foundDog.dto.FoundDogPost;
import com.trishla.aurora.post.lostDog.dto.LostDogPost;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
    private long UID;
    private String name;
    private String emailAddress;
    private String contactNumber;
    private List<LostDogPost> lostDogPosts;
    private List<FoundDogPost> foundDogPosts;
}