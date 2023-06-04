package com.trishla.aurora.post.foundDog.dao;

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
public class FoundDogDao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long UID;

    private String breed;
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attributes_id", referencedColumnName = "UID")
    private DogPhysicalAttributesDao distinctiveFeatures;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "UID")
    private LocationDao locationFoundAt;

    private Instant dateFound;
    private String finderName;
    private String finderEmail;
    private String finderPhone;
    private String message;
    private byte[] photo;

    @OneToOne(mappedBy = "foundDog")
    private FoundDogPostDao foundDogPost;
}