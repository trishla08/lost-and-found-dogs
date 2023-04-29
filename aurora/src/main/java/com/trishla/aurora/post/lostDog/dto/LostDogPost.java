package com.trishla.aurora.post.lostDog.dto;

import java.time.Instant;

import com.trishla.aurora.post.common.dto.PostStatus;

public class LostDogPost {
    private int UID;
    private String title;
    private LostDog lostDog;
    private PostStatus postStatus;
    private Instant postCreationTimestamp;
    private int userID;
}