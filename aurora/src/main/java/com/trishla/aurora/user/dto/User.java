package com.trishla.aurora.user.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
    private int UID;
    private String name;
    private String emailAddress;
    private String contactNumber;
    private List<String> lostDogPosts;
    private List<String> foundDogPosts;
}