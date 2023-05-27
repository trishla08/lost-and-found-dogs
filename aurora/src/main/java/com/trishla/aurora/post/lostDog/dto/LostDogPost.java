package com.trishla.aurora.post.lostDog.dto;

import java.time.Instant;

import com.trishla.aurora.post.common.dto.PostStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LostDogPost {
    private long UID;
    private String title;
    private LostDog lostDog;
    private PostStatus postStatus;
    private Instant postCreationTimestamp;
    private int userID;
}