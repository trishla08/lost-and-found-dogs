package com.trishla.aurora.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import lombok.Getter;

@Getter
public class LostDog implements Serializable{
    final String uid;
    final String name;
    final int age;
    final String sex;
    final String breed;
    final MapLocation location;
    final String city;
    final String photo;
    final String message;
    final String ownerName;
    final String ownerEmail;
    final String ownerNumber;
    final ImmutableMap<String, String> physicalAttributes;
    final Status currentStatus;

    public enum Status {
        Lost,
        Found
    }

    private LostDog(Builder builder) {
        this.uid = builder.uid;
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.breed = builder.breed;
        this.location = builder.location;
        this.city = builder.city;
        this.photo = builder.photo;
        this.message = builder.message;
        this.ownerName = builder.ownerName;
        this.ownerEmail = builder.ownerEmail;
        this.ownerNumber = builder.ownerNumber;
        this.physicalAttributes = ImmutableMap.copyOf(builder.physicalAttributes);
        this.currentStatus = builder.currentStatus;
    }

    public static class Builder {
        String uid;
        String name;
        int age;
        String sex;
        String breed;
        MapLocation location;
        String city;
        String photo;
        String message;
        String ownerName;
        String ownerEmail;
        String ownerNumber;
        Map<String, String> physicalAttributes = new HashMap<>();
        Status currentStatus;
        
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        
        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }
        
        public Builder breed(String breed) {
            this.breed = breed;
            return this;
        }
        
        public Builder location(MapLocation location) {
            this.location = location;
            return this;
        }
        
        public Builder city(String city) {
            this.city = city;
            return this;
        }
        
        public Builder photo(String photo) {
            this.photo = photo;
            return this;
        }
        
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        
        public Builder ownerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }
        
        public Builder ownerEmail(String ownerEmail) {
            this.ownerEmail = ownerEmail;
            return this;
        }
        
        public Builder ownerNumber(String ownerNumber) {
            this.ownerNumber = ownerNumber;
            return this;
        }
        
        public Builder physicalAttributes(Map<String, String> physicalAttributes) {
            this.physicalAttributes.putAll(physicalAttributes);
            return this;
        }
        
        public Builder currentStatus(Status currentStatus) {
            this.currentStatus = currentStatus;
            return this;
        }

        public LostDog build() {
            return new LostDog(this);
        }
    }
}