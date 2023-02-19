package com.trishla.aurora.dtos;

import java.io.Serializable;

import com.google.common.collect.ImmutableMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Repository;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.Data;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder(setterPrefix = "set")
@Entity
@Data
public class LostDog implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uid;

    private String name;
    private int age;
    private String sex;
    private String breed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "ID")
    private MapLocation location;

    private String city;
    private String photo;
    private String message;
    private String ownerName;
    private String ownerEmail;
    private String ownerNumber;

    @Singular private ImmutableMap<String, String> physicalAttributes;
    
    private Status currentStatus;

    public enum Status {
        Lost,
        Found
    }
}