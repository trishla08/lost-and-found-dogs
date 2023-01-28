package com.trishla.aurora.dtos;

import java.io.Serializable;

import com.google.common.collect.ImmutableMap;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FoundDog implements Serializable {
    private final String uid;
    private final String sex;
    private final String breed;
    private final MapLocation location;
    private final String city;
    private final String photo;
    private final String message;
    private final String finderName;
    private final String finderEmail;
    private final String finderNumber;
    private final ImmutableMap<String, String> physicalAttributes;
}