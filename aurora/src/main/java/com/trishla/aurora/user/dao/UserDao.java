package com.trishla.aurora.user.dao;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class UserDao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long UID;
    private String name;
    private String emailAddress;
    private String contactNumber;
    
    @ElementCollection
    private List<String> lostDogPosts;

    @ElementCollection
    private List<String> foundDogPosts;
}