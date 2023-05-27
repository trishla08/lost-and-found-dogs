package com.trishla.aurora.post.common.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.trishla.aurora.post.foundDog.dao.FoundDogDao;
import com.trishla.aurora.post.lostDog.dao.LostDogDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int UID;

    private Double latitude;
    private Double longitude;

    @OneToOne(mappedBy = "lastKnownLocation")
    private LostDogDao lostDog;

    @OneToOne(mappedBy = "locationFoundAt")
    private FoundDogDao foundDog;
}
