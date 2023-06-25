package com.trishla.aurora.post.lostDog.dto;

import java.time.Instant;

import com.trishla.aurora.post.common.dto.PostStatus;
import com.trishla.aurora.user.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LostDogPost {
    private long UID;
    private String title;
    private LostDog lostDog;
    private PostStatus postStatus;
    private Instant postCreationTimestamp;
    private User user;
}