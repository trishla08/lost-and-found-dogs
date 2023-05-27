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
    private boolean collar;
    private boolean coat;
    private boolean wounded;
    private boolean furry;
    private boolean limping;
    private Weight weight;
    private boolean sterilised;
}
