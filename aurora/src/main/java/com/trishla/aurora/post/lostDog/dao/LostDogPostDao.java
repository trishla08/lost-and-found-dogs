package com.trishla.aurora.post.lostDog.dao;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.trishla.aurora.post.common.dto.PostStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LostDogPostDao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long UID;
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lostdog_id", referencedColumnName = "UID")
    private LostDogDao lostDog;

    private PostStatus postStatus;
    private Instant postCreationTimestamp;
    private int userID;
}