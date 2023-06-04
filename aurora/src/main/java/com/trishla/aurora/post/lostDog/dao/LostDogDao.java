package com.trishla.aurora.post.lostDog.dao;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.trishla.aurora.post.common.dao.DogPhysicalAttributesDao;
import com.trishla.aurora.post.common.dao.LocationDao;
import com.trishla.aurora.post.common.dto.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LostDogDao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long UID;
    private String name;
    private String breed;
    private int age;
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attributes_id", referencedColumnName = "UID")
    private DogPhysicalAttributesDao distinctiveFeatures;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "UID")
    private LocationDao lastKnownLocation;

    private Instant dateLost;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;
    private String message;
    private byte[] photo;

    @OneToOne(mappedBy = "lostDog")
    private LostDogPostDao lostDogPost;
}