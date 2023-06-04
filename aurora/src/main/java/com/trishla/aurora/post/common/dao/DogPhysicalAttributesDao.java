package com.trishla.aurora.post.common.dao;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.trishla.aurora.post.common.dto.Coat;
import com.trishla.aurora.post.common.dto.Collar;
import com.trishla.aurora.post.common.dto.Colour;
import com.trishla.aurora.post.common.dto.Furry;
import com.trishla.aurora.post.common.dto.Limping;
import com.trishla.aurora.post.common.dto.Size;
import com.trishla.aurora.post.common.dto.Sterilised;
import com.trishla.aurora.post.common.dto.Weight;
import com.trishla.aurora.post.common.dto.Wounded;
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
public class DogPhysicalAttributesDao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int UID;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Colour> colours;

    @Enumerated(EnumType.ORDINAL)
    private Size size;

    @Enumerated(EnumType.ORDINAL)
    private Collar collar;

    @Enumerated(EnumType.ORDINAL)
    private Coat coat;

    @Enumerated(EnumType.ORDINAL)
    private Wounded wounded;

    @Enumerated(EnumType.ORDINAL)
    private Furry furry;

    @Enumerated(EnumType.ORDINAL)
    private Limping limping;

    @Enumerated(EnumType.ORDINAL)
    private Weight weight;
    
    @Enumerated(EnumType.ORDINAL)
    private Sterilised sterilised;

    @OneToOne(mappedBy = "distinctiveFeatures")
    private LostDogDao lostDog;

    @OneToOne(mappedBy = "distinctiveFeatures")
    private FoundDogDao foundDog;
}
