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

import com.trishla.aurora.post.common.dto.Colour;
import com.trishla.aurora.post.common.dto.Size;
import com.trishla.aurora.post.common.dto.Weight;
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

    private boolean collar;
    private boolean coat;
    private boolean wounded;
    private boolean furry;
    private boolean limping;

    @Enumerated(EnumType.ORDINAL)
    private Weight weight;
    
    private boolean sterilised;

    @OneToOne(mappedBy = "distinctiveFeatures")
    private LostDogDao lostDog;

    @OneToOne(mappedBy = "distinctiveFeatures")
    private FoundDogDao foundDog;
}
