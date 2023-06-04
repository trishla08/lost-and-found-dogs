package com.trishla.aurora.post.common.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DogPhysicalAttributes {
    private List<Colour> colours;
    private Size size;
    private Collar collar;
    private Coat coat;
    private Wounded wounded;
    private Furry furry;
    private Limping limping;
    private Weight weight;
    private Sterilised sterilised;
}
