package com.trishla.aurora.post.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Location {
    private Double latitude;
    private Double longitude;
}
