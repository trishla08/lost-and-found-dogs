package com.trishla.aurora.user.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.trishla.aurora.post.foundDog.dao.FoundDogPostDao;
import com.trishla.aurora.post.lostDog.dao.LostDogPostDao;

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
    private String UID;

    private String name;
    private String emailAddress;
    private String contactNumber;
    private String passwordHash;
    private String passwordSalt;

    @OneToMany(mappedBy = "user")
    private List<FoundDogPostDao> foundDogPosts;

    @OneToMany(mappedBy = "user")
    private List<LostDogPostDao> lostDogPosts;
}