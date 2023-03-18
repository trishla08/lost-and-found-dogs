package com.trishla.aurora.new_dtos;

import java.time.Instant;
import java.util.List;

public class LostDog {
    private int UID;
    private String name;
    private String breed;
    private int age;
    private Size size;
    private Gender gender;
    private String colour;
    private DogPhysicalAttributes distinctiveFeatures;
    private Location lastKnownLocation;
    private Instant dateLost;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;
    private String message;
    private List<byte[]> photo;
}