package com.trishla.aurora.post.foundDog.dao;

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
@NoArgsConstructor
@AllArgsConstructor
public class FoundDogPostDao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int UID;
    
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "founddog_id", referencedColumnName = "UID")
    private FoundDogDao foundDog;

    private PostStatus postStatus;
    private Instant postCreationTimestamp;
    private int userID;
}