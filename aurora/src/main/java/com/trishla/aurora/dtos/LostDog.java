package com.trishla.aurora.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LostDog implements Serializable {
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
    ImmutableMap<String, String> physicalAttributes;
    Status currentStatus;

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

        public Builder setUid(String uid) {
            this.uid = uid;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder setLocation(MapLocation location) {
            this.location = location;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder ownerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Builder setOwnerEmail(String ownerEmail) {
            this.ownerEmail = ownerEmail;
            return this;
        }

        public Builder setOwnerNumber(String ownerNumber) {
            this.ownerNumber = ownerNumber;
            return this;
        }

        public Builder setPhysicalAttributes(Map<String, String> physicalAttributes) {
            this.physicalAttributes.putAll(physicalAttributes);
            return this;
        }

        public Builder setCurrentStatus(Status currentStatus) {
            this.currentStatus = currentStatus;
            return this;
        }

        public LostDog build() {
            return new LostDog(this);
        }

        @Override
        public String toString() {
            return "Builder [uid=" + uid + ", name=" + name + ", age=" + age + ", sex=" + sex + ", breed=" + breed
                    + ", location=" + location + ", city=" + city + ", photo=" + photo + ", message=" + message
                    + ", ownerName=" + ownerName + ", ownerEmail=" + ownerEmail + ", ownerNumber=" + ownerNumber
                    + ", physicalAttributes=" + physicalAttributes + ", currentStatus=" + currentStatus + "]";
        }
    }
}