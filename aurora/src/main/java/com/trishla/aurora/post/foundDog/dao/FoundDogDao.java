package com.trishla.aurora.post.foundDog.dao;

import java.time.Instant;
import java.util.List;

import com.trishla.aurora.post.common.dto.DogPhysicalAttributes;
import com.trishla.aurora.post.common.dto.Gender;
import com.trishla.aurora.post.common.dto.Location;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FoundDogDao {
    private int UID;
    private String breed;
    private Gender gender;
    private DogPhysicalAttributes distinctiveFeatures;
    private Location locationFoundAt;
    private Instant dateFound;
    private String finderName;
    private String finderEmail;
    private String finderPhone;
    private String message;
    private List<byte[]> photo;
}