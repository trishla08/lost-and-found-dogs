package com.trishla.aurora.post.lostDog.dao;

import java.time.Instant;

import com.trishla.aurora.post.common.dto.PostStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LostDogPostDao {
    private int UID;
    private String title;
    private LostDogDao lostDog;
    private PostStatus postStatus;
    private Instant postCreationTimestamp;
    private int userID;
}