package com.trishla.aurora.dtos.requests;

import com.google.common.collect.ImmutableMap;
import com.trishla.aurora.dtos.MapLocation;
import com.trishla.aurora.dtos.LostDog.Status;

import lombok.Getter;

@Getter
public class SearchDogsRequest {
    String name;
    String sex;
    String breed;
    MapLocation location;
    String city;
    String message;
    ImmutableMap<String, String> physicalAttributes;
    Status currentStatus;

    public SearchDogsRequest() {}

    public void create(String name, String sex, String breed, String city, Double latitude, Double longitude,
            Double maxDistance, Status status, String message, String colour, Boolean collar, Boolean coat,
            Boolean limping, Boolean furry) {
        this.name = name;
        this.sex = sex;
        this.breed = breed;
        this.city = city;
        this.location = new MapLocation(latitude, longitude);
        this.message = message;
        this.physicalAttributes = ImmutableMap.of("colour", colour, "collar", collar.toString(), "coat",
                coat.toString(),
                "limping", limping.toString(), "furry", furry.toString());
        this.currentStatus = status;
    }
}
