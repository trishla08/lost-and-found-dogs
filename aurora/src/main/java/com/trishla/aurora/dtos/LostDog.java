package com.trishla.aurora.dtos;

import java.io.Serializable;

import com.google.common.collect.ImmutableMap;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class LostDog implements Serializable {
    private final String uid;
    private final String name;
    private final int age;
    private final String sex;
    private final String breed;
    private final MapLocation location;
    private final String city;
    private final String photo;
    private final String message;
    private final String ownerName;
    private final String ownerEmail;
    private final String ownerNumber;
    private final ImmutableMap<String, String> physicalAttributes;
    private final Status currentStatus;

    public enum Status {
        Lost,
        Found
    }
}