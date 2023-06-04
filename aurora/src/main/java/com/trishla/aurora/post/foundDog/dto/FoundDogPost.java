package com.trishla.aurora.post.foundDog.dto;

import java.time.Instant;

import com.trishla.aurora.post.common.dto.PostStatus;
import com.trishla.aurora.user.dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FoundDogPost {
    private long UID;
    private String title;
    private FoundDog foundDog;
    private PostStatus postStatus;
    private Instant postCreationTimestamp;
    private User user;
}