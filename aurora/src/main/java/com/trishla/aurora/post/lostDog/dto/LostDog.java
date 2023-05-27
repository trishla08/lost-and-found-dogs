package com.trishla.aurora.post.lostDog.dto;

import java.time.Instant;
import com.trishla.aurora.post.common.dto.DogPhysicalAttributes;
import com.trishla.aurora.post.common.dto.Gender;
import com.trishla.aurora.post.common.dto.Location;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LostDog {
    private int UID;
    private String name;
    private String breed;
    private int age;
    private Gender gender;
    private DogPhysicalAttributes distinctiveFeatures;
    private Location lastKnownLocation;
    private Instant dateLost;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;
    private String message;
    private byte[] photo;
}