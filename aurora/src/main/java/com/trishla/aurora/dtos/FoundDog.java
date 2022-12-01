package com.trishla.aurora.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import lombok.Getter;

@Getter
public class FoundDog implements Serializable {
    final String uid;
    final String sex;
    final String breed;
    final MapLocation location;
    final String city;
    final String photo;
    final String message;
    final String finderName;
    final String finderEmail;
    final String finderNumber;
    final ImmutableMap<String, String> physicalAttributes;

    private FoundDog(Builder builder) {
        this.uid = builder.uid;
        this.sex = builder.sex;
        this.breed = builder.breed;
        this.location = builder.location;
        this.city = builder.city;
        this.photo = builder.photo;
        this.message = builder.message;
        this.finderName = builder.finderName;
        this.finderEmail = builder.finderEmail;
        this.finderNumber = builder.finderNumber;
        this.physicalAttributes = ImmutableMap.copyOf(builder.physicalAttributes);
    }

    public static class Builder {
        String uid;
        String sex;
        String breed;
        MapLocation location;
        String city;
        String photo;
        String message;
        String finderName;
        String finderEmail;
        String finderNumber;
        Map<String, String> physicalAttributes = new HashMap<>();
        
        public Builder uid(String uid) {
            this.uid = uid;
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
        
        public Builder finderName(String finderName) {
            this.finderName = finderName;
            return this;
        }
        
        public Builder finderEmail(String finderEmail) {
            this.finderEmail = finderEmail;
            return this;
        }
        
        public Builder finderNumber(String finderNumber) {
            this.finderNumber = finderNumber;
            return this;
        }
        
        public Builder physicalAttributes(Map<String, String> physicalAttributes) {
            this.physicalAttributes.putAll(physicalAttributes);
            return this;
        }

        public FoundDog build() {
            return new FoundDog(this);
        }
    }
}