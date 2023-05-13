package com.trishla.aurora.post.foundDog.dao;

import java.time.Instant;

import com.trishla.aurora.post.common.dto.PostStatus;
import com.trishla.aurora.post.foundDog.dto.FoundDog;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FoundDogPostDao {
    private int UID;
    private String title;
    private FoundDog foundDog;
    private PostStatus postStatus;
    private Instant postCreationTimestamp;
    private int userID;
}