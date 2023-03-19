package com.trishla.aurora.post.foundDog.dto;

import java.time.Instant;

import com.trishla.aurora.post.common.dto.PostStatus;

public class FoundDogPost {
    private int UID;
    private String title;
    private FoundDog foundDog;
    private PostStatus postStatus;
    private Instant postCreationTimestamp;
    private int userID;
}